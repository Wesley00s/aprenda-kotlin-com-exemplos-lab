package entities

import enumeration.Nivel
import enumeration.Situacao
import enumeration.Situacao.*
import utility.Util.Companion.printGreen
import utility.Util.Companion.printBlue

data class Conteudo(
    var nivel: Nivel?,
    val id: String,
    val nomeConteudo: String,
    val desc: String,
    val duracao: Double,
) {

    var situacaoConteudo: Situacao = PENDENTE

    fun concluirConteudo() {
        situacaoConteudo = CONCLUIDO
    }

    override fun toString(): String {
        fun funcaoCor(str: String) = when (situacaoConteudo) {
            PENDENTE -> printBlue(str)
            CONCLUIDO -> printGreen(str)
        }
        return funcaoCor(
            """
    |       ---------------------------------------------------------
    |       Nível do conteúdo: $nivel
    |       ID do conteúdo: $id
    |       Nome do conteúdo: $nomeConteudo
    |       Descrição do conteúdo: $desc
    |       Duração: ${duracao}H
    |       Situação conteúdo: $situacaoConteudo"""
        )
    }
}
