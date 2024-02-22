package ru.gazprombank.servermanager.request

import jakarta.validation.constraints.*
import ru.gazprombank.servermanager.util.VALID_IPV4_REGEX

data class CreateServerRequest(
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:NotBlank(message = "Manufacturer is required")
    val manufacturer: String,
    @field:Pattern(
        regexp = VALID_IPV4_REGEX,
        message = "Not valid IPv4 address"
    )
    val ipv4Address: String,
    @field:DecimalMin(value = "0.0", message = "RAM should not be zero")
    val ram: Double,
    @field:DecimalMin(value = "0.0", message = "Storage should not be zero")
    val storage: Double,
    val responsibleEmployeeId: Long
)
