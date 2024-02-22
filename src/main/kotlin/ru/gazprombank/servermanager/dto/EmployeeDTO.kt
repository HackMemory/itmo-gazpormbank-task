package ru.gazprombank.servermanager.dto

data class EmployeeDTO(
    val employeeId: Long? = null,
    val name: String,
    val departmentId: Long? = null
)