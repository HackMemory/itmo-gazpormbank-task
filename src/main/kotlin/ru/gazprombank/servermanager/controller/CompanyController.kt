package ru.gazprombank.servermanager.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.gazprombank.servermanager.converter.toDTO
import ru.gazprombank.servermanager.dto.CompanyDTO
import ru.gazprombank.servermanager.request.CompanyRequest
import ru.gazprombank.servermanager.service.CompanyService

@RestController
@RequestMapping("/api/v1/company")
class CompanyController(private val companyService: CompanyService) {

    @GetMapping("/list")
    fun getAllCompanies(): ResponseEntity<List<CompanyDTO>> {
        val companies = companyService.getAllCompanies().map { it.toDTO() }
        return ResponseEntity(companies, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getCompanyById(@PathVariable id: Long): ResponseEntity<CompanyDTO> {
        val company = companyService.getCompanyById(id).toDTO()
        return ResponseEntity(company, HttpStatus.OK)
    }

    @PostMapping
    fun createCompany(@RequestBody companyRequest: CompanyRequest): ResponseEntity<CompanyDTO> {
        val createdCompany = companyService.createCompany(companyRequest).toDTO()
        return ResponseEntity(createdCompany, HttpStatus.CREATED)
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: Long): ResponseEntity<Unit> {
        companyService.deleteCompany(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}