package com.ramon.hamburgueria.exception

data class MensagemException(
    val status: Int,
    val mensagem: String?
)