package ru.gazprombank.servermanager.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.gazprombank.servermanager.model.Employee

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>