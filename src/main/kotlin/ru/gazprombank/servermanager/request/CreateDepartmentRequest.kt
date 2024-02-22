package ru.gazprombank.servermanager.request

data class CreateDepartmentRequest(
    val name: String,
    val companyId: Long
)