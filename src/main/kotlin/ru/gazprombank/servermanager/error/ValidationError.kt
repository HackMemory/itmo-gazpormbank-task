package ru.gazprombank.servermanager.error

import org.springframework.http.HttpStatus

class ValidationError(
    val status: Int? = null,
    val errors: List<String>
) {
    constructor(httpStatus: HttpStatus, errors: List<String>) : this(
        status = httpStatus.value(),
        errors = errors
    )
}