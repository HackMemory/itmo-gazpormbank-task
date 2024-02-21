package ru.gazprombank.servermanager.model

import jakarta.persistence.*

@Entity
data class Department(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val departmentId: Long? = null,
    val name: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    val company: Company
)