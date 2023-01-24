package org.xavrs.streaming.springboot3.application.exception.handler

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.time.LocalDateTime
@ControllerAdvice
class HttpExceptionHandler {
    @ResponseBody
    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequestException(
        exception: RuntimeException,
        httpServletRequest: HttpServletRequest
    ): ResponseEntity<ApiError> {
        return ResponseEntity(
            createError(exception, httpServletRequest, HttpStatus.BAD_REQUEST),
            HttpStatus.BAD_REQUEST
        )
    }

    private fun createError(
        exception: RuntimeException,
        httpServletRequest: HttpServletRequest,
        errorCode: HttpStatus
    ): ApiError {
        return ApiError(
            status = errorCode.value(),
            error = errorCode.reasonPhrase,
            exception = exception.javaClass.canonicalName,
            message = exception.localizedMessage,
            path = httpServletRequest.requestURI
        )
    }
}

data class ApiError(
    val status: Int,
    val error: String,
    val exception: String,
    val message: String,
    val path: String
){
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    val timestamp: LocalDateTime = LocalDateTime.now()
}