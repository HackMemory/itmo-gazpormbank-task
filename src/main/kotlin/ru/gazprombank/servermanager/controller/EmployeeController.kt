package ru.gazprombank.servermanager.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.gazprombank.servermanager.converter.toDTO
import ru.gazprombank.servermanager.dto.EmployeeDTO
import ru.gazprombank.servermanager.request.CreateEmployeeRequest
import ru.gazprombank.servermanager.service.EmployeeService

@RestController
@RequestMapping("/api/v1/employee")
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping("/list")
    fun getAllEmployees(): ResponseEntity<List<EmployeeDTO>> {
        val employees = employeeService.getAllEmployees().map { it.toDTO() }
        return ResponseEntity(employees, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getEmployeeById(@PathVariable id: Long): ResponseEntity<EmployeeDTO> {
        val employee = employeeService.getEmployeeById(id).toDTO()
        return ResponseEntity(employee, HttpStatus.OK)
    }

    @PostMapping
    fun createEmployee(@Validated @RequestBody employeeRequest: CreateEmployeeRequest): ResponseEntity<EmployeeDTO> {
        val createdEmployee = employeeService.createEmployee(employeeRequest).toDTO()
        return ResponseEntity(createdEmployee, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Unit> {
        employeeService.deleteEmployee(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}