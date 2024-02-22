package ru.gazprombank.servermanager.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.gazprombank.servermanager.converter.toDTO
import ru.gazprombank.servermanager.dto.ServerDTO
import ru.gazprombank.servermanager.request.CreateServerRequest
import ru.gazprombank.servermanager.request.UpdateServerRequest
import ru.gazprombank.servermanager.service.ServerService

@RestController
@RequestMapping("/api/v1/server")
class ServerController(private val serverService: ServerService) {

    @GetMapping("/list")
    fun getAllServers(): ResponseEntity<List<ServerDTO>> {
        val servers = serverService.getAllServers().map { it.toDTO() }
        return ResponseEntity(servers, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getServerById(@PathVariable id: Long): ResponseEntity<ServerDTO> {
        val server = serverService.getServerById(id).toDTO()
        return ResponseEntity(server, HttpStatus.OK)
    }

    @PostMapping
    fun createServer(@RequestBody serverRequest: CreateServerRequest): ResponseEntity<ServerDTO> {
        val createdServer = serverService.createServer(serverRequest).toDTO()
        return ResponseEntity(createdServer, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateServer(@PathVariable id: Long, @RequestBody updateRequest: UpdateServerRequest): ResponseEntity<ServerDTO> {
        val updatedServer = serverService.updateServer(id, updateRequest).toDTO()
        return ResponseEntity(updatedServer, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteServer(@PathVariable id: Long): ResponseEntity<Unit> {
        serverService.deleteServer(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}