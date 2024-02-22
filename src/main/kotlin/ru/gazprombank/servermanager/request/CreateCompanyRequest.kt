package ru.gazprombank.servermanager.request

import jakarta.validation.constraints.NotBlank

data class CreateCompanyRequest(
    @field:NotBlank(message = "Name is required")
    val name: String
)