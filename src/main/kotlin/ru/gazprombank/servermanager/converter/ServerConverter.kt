package ru.gazprombank.servermanager.converter

import ru.gazprombank.servermanager.dto.ServerDTO
import ru.gazprombank.servermanager.model.Employee
import ru.gazprombank.servermanager.model.Server
import ru.gazprombank.servermanager.request.CreateServerRequest
import ru.gazprombank.servermanager.request.UpdateServerRequest

fun CreateServerRequest.toServer(employee: Employee): Server {
    return Server(
        name = this.name,
        manufacturer = this.manufacturer,
        ipv4Address = this.ipv4Address,
        ram = this.ram,
        storage = this.storage,
        responsibleEmployee = employee
    )
}

fun UpdateServerRequest.toServer(employee: Employee, existingServerId: Long): Server {
    return Server(
        serverId = existingServerId,
        name = this.name,
        manufacturer = this.manufacturer,
        ipv4Address = this.ipv4Address,
        ram = this.ram,
        storage = this.storage,
        responsibleEmployee = employee
    )
}

fun Server.toDTO(): ServerDTO {
    return ServerDTO(
        serverId = this.serverId,
        name = this.name,
        manufacturer = this.manufacturer,
        ipv4Address = this.ipv4Address,
        ram = this.ram,
        storage = this.storage,
        responsibleEmployeeId = this.responsibleEmployee?.employeeId
    )
}