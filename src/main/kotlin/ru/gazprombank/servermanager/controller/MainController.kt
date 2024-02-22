package ru.gazprombank.servermanager.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import ru.gazprombank.servermanager.converter.toDTO
import ru.gazprombank.servermanager.dto.EmployeeDTO
import ru.gazprombank.servermanager.dto.ServerDTO
import ru.gazprombank.servermanager.request.CreateServerRequest
import ru.gazprombank.servermanager.request.UpdateServerRequest
import ru.gazprombank.servermanager.service.EmployeeService
import ru.gazprombank.servermanager.service.ServerService

@RestController
@RequestMapping("/api/v1/main")
class MainController(
    private val employeeService: EmployeeService,
    private val serverService: ServerService
) {

    // Getting the list of servers in department
    @GetMapping("/servers")
    fun getServersByDepartmentId(@RequestParam departmentId: Long): ResponseEntity<List<ServerDTO>> {
        val servers = serverService.getServersByDepartmentId(departmentId).map { it.toDTO() }
        return ResponseEntity(servers, HttpStatus.OK)
    }

    // Adding a new server
    @PostMapping("/servers")
    fun createServer(@Validated @RequestBody serverRequest: CreateServerRequest): ResponseEntity<ServerDTO> {
        val createdServer = serverService.createServer(serverRequest).toDTO()
        return ResponseEntity(createdServer, HttpStatus.CREATED)
    }

    // Server editing
    @PutMapping("/servers/{id}")
    fun updateServer(
        @PathVariable id: Long,
        @Validated @RequestBody updateServerRequest: UpdateServerRequest
    ): ResponseEntity<ServerDTO> {
        val updatedServer = serverService.updateServer(id, updateServerRequest).toDTO()
        return ResponseEntity(updatedServer, HttpStatus.OK)
    }

    // Getting list of the company employees
    @GetMapping("/employees")
    fun getEmployeesByCompanyId(@RequestParam companyId: Long): ResponseEntity<List<EmployeeDTO>> {
        val employees = employeeService.getEmployeesByCompanyId(companyId).map { it.toDTO() }
        return ResponseEntity(employees, HttpStatus.OK)
    }

    // Removing employee
    @DeleteMapping("/employees/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<Unit> {
        employeeService.deleteEmployee(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}