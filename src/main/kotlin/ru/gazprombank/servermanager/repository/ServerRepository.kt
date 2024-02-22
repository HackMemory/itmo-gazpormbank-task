package ru.gazprombank.servermanager.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.gazprombank.servermanager.model.Server

@Repository
interface ServerRepository : JpaRepository<Server, Long> {
    fun findByResponsibleEmployeeDepartmentDepartmentId(departmentId: Long): List<Server>
}