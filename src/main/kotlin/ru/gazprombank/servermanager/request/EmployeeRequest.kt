package ru.gazprombank.servermanager.request

data class EmployeeRequest(
    val name: String,
    val departmentId: Long
)