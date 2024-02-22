package ru.gazprombank.servermanager.converter

import ru.gazprombank.servermanager.dto.ServerDTO
import ru.gazprombank.servermanager.model.Employee
import ru.gazprombank.servermanager.model.Server
import ru.gazprombank.servermanager.request.ServerRequest

fun ServerRequest.toServer(employee: Employee): Server {
    return Server(
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
        responsibleEmployeeId = this.responsibleEmployee.employeeId
    )
}