package ru.gazprombank.servermanager.service

import org.springframework.stereotype.Service
import ru.gazprombank.servermanager.converter.toServer
import ru.gazprombank.servermanager.exception.NotFoundException
import ru.gazprombank.servermanager.model.Server
import ru.gazprombank.servermanager.repository.ServerRepository
import ru.gazprombank.servermanager.request.CreateServerRequest
import ru.gazprombank.servermanager.request.UpdateServerRequest

@Service
class ServerService(private val serverRepository: ServerRepository,
                    private val employeeService: EmployeeService,
                    private val departmentService: DepartmentService
) {

    fun getAllServers(): List<Server> {
        return serverRepository.findAll()
    }

    fun getServerById(id: Long): Server {
        return serverRepository.findById(id)
            .orElseThrow { NotFoundException("Server not found with id: $id") }
    }

    fun createServer(serverRequest: CreateServerRequest): Server {
        val responsibleEmployee = employeeService.getEmployeeById(serverRequest.responsibleEmployeeId)
        val server = serverRequest.toServer(responsibleEmployee)
        return serverRepository.save(server)
    }

    fun deleteServer(id: Long) {
        val server = getServerById(id)
        serverRepository.delete(server)
    }

    fun updateServer(id: Long, updateRequest: UpdateServerRequest): Server {
        val server = getServerById(id)
        val responsibleEmployee = employeeService.getEmployeeById(updateRequest.responsibleEmployeeId)
        return serverRepository.save(updateRequest.toServer(responsibleEmployee, server.serverId!!))
    }

    fun getServersByDepartmentId(departmentId: Long): List<Server> {
        val department = departmentService.getDepartmentById(departmentId)
        return serverRepository.findByResponsibleEmployeeDepartmentDepartmentId(department.departmentId!!)
    }
}