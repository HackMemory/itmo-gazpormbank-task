package ru.gazprombank.servermanager.error

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.lang.Nullable
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ru.gazprombank.servermanager.exception.NotFoundException
import java.util.*


@RestControllerAdvice
class GlobalExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<CustomError> {
        val errorMessage = CustomError(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: org.springframework.http.HttpHeaders,
        status: HttpStatusCode,
        webRequest: WebRequest
    ): ResponseEntity<Any>? {
        val errors = ex.bindingResult.fieldErrors.map { fieldError ->
            "${fieldError.field}: ${fieldError.defaultMessage}"
        }
        return ResponseEntity.status(status.value()).body(ValidationError(status.value(), errors))
    }

    override fun handleExceptionInternal(
        ex: Exception,
        @Nullable body: Any?,
        headers: org.springframework.http.HttpHeaders,
        statusCode: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any>? {
        val errorMessage = CustomError(
            statusCode.value(),
            ex.message
        )
        return ResponseEntity.status(statusCode).body(errorMessage)
    }
}