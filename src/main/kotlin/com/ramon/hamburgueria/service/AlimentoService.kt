package com.ramon.hamburgueria.service

import com.ramon.hamburgueria.controller.dto.AlimentoDto
import com.ramon.hamburgueria.domain.Alimento
import com.ramon.hamburgueria.repository.AlimentoRepository
import org.springframework.stereotype.Service

@Service
class AlimentoService(
    private val alimentoRepository: AlimentoRepository
) {

    fun salvar(alimentoDto: AlimentoDto): Alimento {
        return  alimentoRepository.save(alimentoDto.paraDominio())
    }

    fun buscarTodos(): List<Alimento> {
        return alimentoRepository.findAll()
    }

    fun buscarComFiltro(pesquisa: String): Alimento {
        val id = pesquisa.toLongOrNull()
        if(id == null){
            return alimentoRepository.findByNome(pesquisa)
        }else{
            return alimentoRepository.findById(id)
        }
    }

    fun deletar(id: Long) {
        alimentoRepository.delete(id)
    }

    fun atualizar(id: Long, alimentoDto: AlimentoDto): Alimento? {
        return alimentoRepository.update(id, alimentoDto)
    }

}