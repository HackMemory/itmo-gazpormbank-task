package ru.gazprombank.servermanager.service

import org.springframework.stereotype.Service
import ru.gazprombank.servermanager.converter.toDepartment
import ru.gazprombank.servermanager.exception.NotFoundException
import ru.gazprombank.servermanager.model.Department
import ru.gazprombank.servermanager.repository.DepartmentRepository
import ru.gazprombank.servermanager.request.DepartmentRequest

@Service
class DepartmentService(
    val departmentRepository: DepartmentRepository,
    val companyService: CompanyService
) {

    fun getAllDepartments(): List<Department> = departmentRepository.findAll()

    fun getDepartmentById(id: Long): Department {
        return departmentRepository.findById(id)
            .orElseThrow { NotFoundException("Department not found with id: $id") }
    }

    fun createDepartment(department: DepartmentRequest): Department {
        val company = companyService.getCompanyById(department.companyId)
        return departmentRepository.save(department.toDepartment(company))
    }

    fun deleteDepartment(id: Long) {
        val department = getDepartmentById(id)
        departmentRepository.delete(department)
    }
}