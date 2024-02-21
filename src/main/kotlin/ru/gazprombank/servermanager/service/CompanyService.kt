package ru.gazprombank.servermanager.service

import org.springframework.stereotype.Service
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

    fun createCompany(company: Company): Company = companyRepository.save(company)

    fun deleteCompany(id: Long) {
        val company = getCompanyById(id);
        companyRepository.delete(company)
    }
}