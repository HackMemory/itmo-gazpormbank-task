package ru.gazprombank.servermanager.converter

import ru.gazprombank.servermanager.dto.EmployeeDTO
import ru.gazprombank.servermanager.model.Department
import ru.gazprombank.servermanager.model.Employee
import ru.gazprombank.servermanager.request.CreateEmployeeRequest

fun CreateEmployeeRequest.toEmployee(department: Department): Employee {
    return Employee(
        name = this.name,
        department = department
    )
}

fun Employee.toDTO(): EmployeeDTO {
    return EmployeeDTO(
        employeeId = this.employeeId,
        name = this.name,
        departmentId = this.department?.departmentId
    )
}