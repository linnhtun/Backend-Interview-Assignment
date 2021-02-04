package com.linnhtun.backendInterview.exception.handler

import com.linnhtun.backendInterview.exception.DuplicateEmailException
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

import java.util.stream.Collectors

import java.time.LocalDate

import java.util.LinkedHashMap
import java.time.LocalDateTime
import javax.servlet.http.HttpServletResponse


@ControllerAdvice
class ValidationHandler : ResponseEntityExceptionHandler() {

    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val body: MutableMap<String, Any> = LinkedHashMap()
        body["timestamp"] = LocalDateTime.now()
        body["message"] = "Body is empty"
        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(DuplicateEmailException::class)
    fun springDuplicateEmail(ex: DuplicateEmailException, response: HttpServletResponse): ResponseEntity<Any> {

        val body: MutableMap<String, Any> = LinkedHashMap()
        body["timestamp"] = LocalDate.now()
        body["status"] = HttpStatus.BAD_REQUEST.value()
        body["message"] = "Duplicate Email"

        return ResponseEntity<Any>(body, HttpStatus.BAD_REQUEST)
    }

    override fun handleMethodArgumentNotValid(
        ex: MethodArgumentNotValidException,
        headers: HttpHeaders,
        status: HttpStatus, request: WebRequest
    ): ResponseEntity<Any> {
        val body: MutableMap<String, Any> = LinkedHashMap()
        body["timestamp"] = LocalDate.now()
        body["status"] = status.value()

        val errors: MutableList<String> = ex.bindingResult
            .fieldErrors
            .stream()
            .map { x -> x.defaultMessage }
            .collect(Collectors.toList())

        body["errors"] = errors

        return ResponseEntity<Any>(body, HttpStatus.BAD_REQUEST)
    }
}