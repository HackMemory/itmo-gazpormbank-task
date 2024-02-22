package ru.gazprombank.servermanager.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.gazprombank.servermanager.converter.toDTO
import ru.gazprombank.servermanager.dto.DepartmentDTO
import ru.gazprombank.servermanager.request.CreateDepartmentRequest
import ru.gazprombank.servermanager.service.DepartmentService

@RestController
@RequestMapping("/api/v1/department")
class DepartmentController(private val departmentService: DepartmentService) {

    @GetMapping("/list")
    fun getAllDepartments(): ResponseEntity<List<DepartmentDTO>> {
        val departments = departmentService.getAllDepartments().map { it.toDTO() }
        return ResponseEntity(departments, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getDepartmentById(@PathVariable id: Long): ResponseEntity<DepartmentDTO> {
        val department = departmentService.getDepartmentById(id).toDTO()
        return ResponseEntity(department, HttpStatus.OK)
    }

    @PostMapping
    fun createDepartment(@RequestBody departmentRequest: CreateDepartmentRequest): ResponseEntity<DepartmentDTO> {
        val createdDepartment = departmentService.createDepartment(departmentRequest).toDTO()
        return ResponseEntity(createdDepartment, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteDepartment(@PathVariable id: Long): ResponseEntity<Unit> {
        departmentService.deleteDepartment(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}