package ru.gazprombank.servermanager.service

import org.springframework.stereotype.Service
import ru.gazprombank.servermanager.converter.toEmployee
import ru.gazprombank.servermanager.exception.NotFoundException
import ru.gazprombank.servermanager.model.Employee
import ru.gazprombank.servermanager.repository.EmployeeRepository
import ru.gazprombank.servermanager.request.CreateEmployeeRequest

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository,
                      private val departmentService: DepartmentService,
                      private val companyService: CompanyService
) {

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun getEmployeeById(id: Long): Employee {
        return employeeRepository.findById(id)
            .orElseThrow { NotFoundException("Employee not found with id: $id") }
    }

    fun createEmployee(employeeRequest: CreateEmployeeRequest): Employee {
        val department = departmentService.getDepartmentById(employeeRequest.departmentId)
        return employeeRepository.save(employeeRequest.toEmployee(department))
    }

    fun deleteEmployee(id: Long) {
        val employee = getEmployeeById(id)
        employeeRepository.delete(employee)
    }

    fun getEmployeesByCompanyId(companyId: Long): List<Employee> {
        val company = companyService.getCompanyById(companyId)
        return employeeRepository.findByDepartmentCompanyCompanyId(company.companyId!!)
    }
}