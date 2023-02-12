package com.ramon.hamburgueria.repository

import com.ramon.hamburgueria.controller.dto.AlimentoDto
import com.ramon.hamburgueria.domain.Alimento

interface AlimentoRepository {

    fun save(alimento: Alimento): Alimento

    fun findAll(): List<Alimento>
    fun findByNome(pesquisa: String): Alimento
    fun findById(id: Long): Alimento
    fun delete(id: Long)
    fun update(id: Long, alimentoDto: AlimentoDto): Alimento?
}