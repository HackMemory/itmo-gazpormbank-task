package ru.gazprombank.servermanager.service

import org.springframework.stereotype.Service
import ru.gazprombank.servermanager.converter.toCompany
import ru.gazprombank.servermanager.request.CompanyRequest
import ru.gazprombank.servermanager.exception.NotFoundException
import ru.gazprombank.servermanager.model.Company
import ru.gazprombank.servermanager.repository.CompanyRepository

@Service
class CompanyService(val companyRepository: CompanyRepository) {

    fun getAllCompanies(): List<Company> = companyRepository.findAll()

    fun getCompanyById(id: Long): Company {
        return companyRepository.findById(id)
            .orElseThrow { NotFoundException("Company not found") }
    }

    fun createCompany(company: CompanyRequest): Company = companyRepository.save(company.toCompany())

    fun deleteCompany(id: Long) {
        val company = getCompanyById(id);
        companyRepository.delete(company)
    }
}