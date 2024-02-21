package ru.gazprombank.servermanager.converter

import ru.gazprombank.servermanager.dto.CompanyDTO
import ru.gazprombank.servermanager.request.CompanyRequest
import ru.gazprombank.servermanager.model.Company

fun CompanyRequest.toCompany(): Company {
    return Company(
        name = this.name
    )
}

fun Company.toDTO(): CompanyDTO {
    return CompanyDTO(
        name = this.name
    )
}