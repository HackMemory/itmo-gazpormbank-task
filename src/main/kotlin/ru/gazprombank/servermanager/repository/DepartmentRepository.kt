package ru.gazprombank.servermanager.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.gazprombank.servermanager.model.Department

@Repository
interface DepartmentRepository : JpaRepository<Department, Long>