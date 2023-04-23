package com.ramon.hamburgueria.repository.model

import com.ramon.hamburgueria.domain.Alimento
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
){

    fun paraDominio(): Alimento {
        return Alimento(
            id = id,
            nome = nome!!,
            descricao = descricao!!,
            preco = preco!!,
            categoria = categoria!!
        )
    }

    companion object{
        fun doDominio(alimento: Alimento): AlimentoEntity{
            return AlimentoEntity(
            id = alimento.id,
            nome = alimento.nome,
            descricao = alimento.descricao,
            preco = alimento.preco,
            categoria = alimento.categoria
            )
        }
    }

}



