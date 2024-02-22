package ru.gazprombank.servermanager.request

data class CreateEmployeeRequest(
    val name: String,
    val departmentId: Long
)