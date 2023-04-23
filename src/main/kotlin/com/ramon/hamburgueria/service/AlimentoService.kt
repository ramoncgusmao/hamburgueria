package com.ramon.hamburgueria.service

import com.ramon.hamburgueria.controller.dto.AlimentoDto
import com.ramon.hamburgueria.domain.Alimento
import com.ramon.hamburgueria.repository.AlimentoRepository
import com.ramon.hamburgueria.repository.model.AlimentoEntity
import org.springframework.stereotype.Service

@Service
class AlimentoService(
    private val alimentoRepository: AlimentoRepository
) {

    fun salvar(alimentoDto: AlimentoDto): Alimento {
        val alimento = alimentoDto.paraDominio()
        return  alimentoRepository.save(AlimentoEntity.doDominio(alimento)).paraDominio()
    }

    fun buscarTodos(): List<Alimento> {
        return alimentoRepository.findAll().map { it.paraDominio() }
    }

    fun buscarComFiltro(pesquisa: String): Alimento {
        val id = pesquisa.toLongOrNull()
        val alimentoEntity = if(id == null){
             alimentoRepository.findByNome(pesquisa)
        }else{
             alimentoRepository.findById(id).orElseThrow()
        }
        return alimentoEntity.paraDominio()
    }

    fun deletar(id: Long) {
        alimentoRepository.deleteById(id)
    }

    fun atualizar(id: Long, alimentoDto: AlimentoDto): Alimento? {
        val alimento = alimentoDto.paraDominio().copy(id = id)
        return alimentoRepository.save(AlimentoEntity.doDominio(alimento)).paraDominio()
    }

}