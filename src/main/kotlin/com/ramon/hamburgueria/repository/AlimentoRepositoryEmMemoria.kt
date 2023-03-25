package com.ramon.hamburgueria.repository

import com.ramon.hamburgueria.controller.dto.AlimentoDto
import com.ramon.hamburgueria.domain.Alimento
import com.ramon.hamburgueria.exception.ElementoNaoEncontradoException
import org.springframework.stereotype.Component

@Component
class AlimentoRepositoryEmMemoria() : AlimentoRepository {
    private val alimentoLista: MutableList<Alimento>
    private var indice: Long = 0

    init{
        alimentoLista = ArrayList()
    }

    override fun save(alimento: Alimento): Alimento {
        indice++
        alimento.id = indice
        alimentoLista.add(alimento)
        return alimento
    }

    override fun findAll(): List<Alimento> {
       return alimentoLista
    }

    override fun findByNome(pesquisa: String): Alimento {
        try{
            return alimentoLista.first{it.nome == pesquisa}
        }catch (exception: NoSuchElementException){
            throw  RuntimeException("não foi possivel pesquisar por nome $pesquisa")
        }

    }

    override fun findById(id: Long): Alimento {
        try{
            return alimentoLista.first{it.id == id}
        }catch (exception: NoSuchElementException){
            throw  ElementoNaoEncontradoException("não foi possivel pesquisar por id $id")
        }

    }

    override fun delete(id: Long) {
       alimentoLista.removeIf{it.id == id}
    }

    override fun update(id: Long, alimentoDto: AlimentoDto): Alimento? {
        var alimentoAtualizado: Alimento? = null
       alimentoLista.forEachIndexed { index, alimento ->
           if(alimento.id == id){
               alimentoLista[index] = alimento.copy(
                   nome = alimentoDto.nome!!,
                   descricao = alimentoDto.descricao!!,
                   preco = alimentoDto.preco!!,
                   categoria = alimentoDto.categoria!!)
               alimentoAtualizado = alimentoLista[index]
           }
       }
        return alimentoAtualizado
    }


}