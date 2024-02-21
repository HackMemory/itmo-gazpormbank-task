package ru.gazprombank.servermanager.dto

data class DepartmentDTO(
    val departmentId: Long? = null,
    val name: String,
    val companyId: Long? = null
)