package ru.gazprombank.servermanager.dto

data class ServerDTO(
    val serverId: Long? = null,
    val name: String,
    val manufacturer: String,
    val ipv4Address: String,
    val ram: Double,
    val storage: Double,
    val responsibleEmployeeId: Long? = null
)