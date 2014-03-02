package com.impaq.arena.server.login.util

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

import javax.servlet.http.HttpServletResponse
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

@ControllerAdvice
class ExceptionsResolver {

    @ExceptionHandler(ConstraintViolationException)
    void handle(ConstraintViolationException ex, HttpServletResponse response) {
        String msg = ex.getConstraintViolations().collect { ConstraintViolation<?> violation ->
            "'${violation.propertyPath}' property value of '${violation.invalidValue}': ${violation.message}"
        }.join(", ")
        response.sendError(UNPROCESSABLE_ENTITY.value(), "Validation error(s): $msg")
    }

    @ExceptionHandler(RuntimeException)
    void handle(RuntimeException ex, HttpServletResponse response) {
        response.sendError(INTERNAL_SERVER_ERROR.value(), "BOOM !!!")
    }

}
