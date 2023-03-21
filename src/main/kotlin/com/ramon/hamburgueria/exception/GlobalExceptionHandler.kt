package com.ramon.hamburgueria.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpServerErrorException.InternalServerError

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleInternalServerErrorException(ex: InternalServerError): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler
    fun handleNoSuchElementExceptionException(ex: NoSuchElementException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleRuntimeExceptionException(ex: RuntimeException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.BAD_REQUEST.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleElementoNaoEncontradoException(ex: ElementoNaoEncontradoException): ResponseEntity<MensagemException>{

        val mensagemException = MensagemException(
            HttpStatus.NOT_FOUND.value(),
            ex.message
        )

        return ResponseEntity(mensagemException, HttpStatus.NOT_FOUND)
    }
}