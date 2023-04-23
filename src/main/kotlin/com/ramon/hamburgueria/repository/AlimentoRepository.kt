package com.ramon.hamburgueria.repository

import com.ramon.hamburgueria.controller.dto.AlimentoDto
import com.ramon.hamburgueria.domain.Alimento
import com.ramon.hamburgueria.repository.model.AlimentoEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AlimentoRepository: JpaRepository<AlimentoEntity, Long> {


    fun findByNome(pesquisa: String): AlimentoEntity

}