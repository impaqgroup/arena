package com.impaq.arena.server.login.util

import org.springframework.transaction.TransactionSystemException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

import javax.servlet.http.HttpServletResponse
import javax.validation.ConstraintViolationException

import static org.springframework.http.HttpStatus.*

@ControllerAdvice
class ExceptionsResolver {

    @ExceptionHandler(ConstraintViolationException)
    void handle(ConstraintViolationException ex, HttpServletResponse response) {
        response.sendError(UNPROCESSABLE_ENTITY.value(), ex.getMessage())
    }

    @ExceptionHandler(TransactionSystemException)
    void handle(TransactionSystemException ex, HttpServletResponse response) {
        response.sendError(INTERNAL_SERVER_ERROR.value(), "BOOM!")
    }

}
