package ru.gazprombank.servermanager.request

data class DepartmentRequest(
    val name: String,
    val companyId: Long
)