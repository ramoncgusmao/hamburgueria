package com.ramon.hamburgueria.repository.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "alimento")
data class AlimentoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
)



