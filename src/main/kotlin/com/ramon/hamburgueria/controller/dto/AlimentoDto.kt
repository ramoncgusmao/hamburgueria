package com.ramon.hamburgueria.controller.dto

import com.ramon.hamburgueria.domain.Alimento
import jakarta.validation.constraints.*
import java.math.BigDecimal

class AlimentoDto(
    @field:NotBlank(message = "o nome é obrigatorio")
    @field:Size(min = 3, max = 20, message = "o nome deve ter mais que 3 e menos que 20 caracteres")
    val nome: String? = null,
    @field:NotBlank(message = "a descrição é obrigatorio")
    val descricao: String? = null,
    @field:NotNull(message = "o preço é obrigatorio")
    @field:Min(value = 0, message = "o preço deve ser maior que zero")
    val preco: BigDecimal? = null,
    @field:NotBlank(message = "a categoria é obrigatorio")
    @field:Size(max = 20, message = "a categoria deve ter menos que 20 caracteres")
    val categoria: String? = null
) {
    fun paraDominio(): Alimento {
        return Alimento(
            id = null,
            nome = nome!!,
            descricao = descricao!!,
            preco = preco!!,
            categoria = categoria!!
        )
    }
}