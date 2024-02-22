package ru.gazprombank.servermanager.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateDepartmentRequest(
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:NotNull(message = "Company id is required")
    val companyId: Long
)