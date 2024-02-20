package ru.gazprombank.servermanager.model

import jakarta.persistence.*

@Entity
data class Server(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val serverId: Long = 0,
    val name: String,
    val manufacturer: String,
    @Column(name = "ipv4_address")
    val ipv4Address: String,
    val ram: Double,
    val storage: Double,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_employee_id")
    val responsibleEmployee: Employee
)