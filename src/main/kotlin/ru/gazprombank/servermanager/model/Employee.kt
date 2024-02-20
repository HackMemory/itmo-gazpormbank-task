package ru.gazprombank.servermanager.model

import jakarta.persistence.*

@Entity
data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val employeeId: Long,
    val name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    val department: Department
)