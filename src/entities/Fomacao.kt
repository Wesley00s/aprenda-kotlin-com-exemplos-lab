package entities;

import enumeration.Situacao.*
import utility.Util.Companion.printGreen
import utility.Util.Companion.printBlue

data class Formacao (
    var idFormacao: String,
    val nomeFormacao: String,
) {
    var situacaoFormacao = PENDENTE
    var conteudos = mutableSetOf<Conteudo>()

    fun duracao(): Double {
        var duracaoTotal = 0.0
        for (conteudo in conteudos) {
            duracaoTotal += conteudo.duracao
        }
        return duracaoTotal
    }

    fun adicionarConteudo(conteudo: Conteudo) {
        if (conteudos.contains(conteudo)) {
            println("O conteúdo já está presente da formação.")
            return
        }
        conteudos.add(conteudo)
    }

    fun verConteudos(): String {
        val conteudosString = StringBuilder()
        if (conteudos.isEmpty()) return "\t\tNenhum conteúdo"
        conteudosString.append("|\t\tCONTEÚDOS\n")
        for (conteudo in conteudos) {
            conteudosString.append("\t|$conteudo\n")
        }
        return conteudosString.toString()
    }

    override fun toString(): String {
        val conteudosString = verConteudos()
        fun funcaoCor(str : String) = when (situacaoFormacao) {
            PENDENTE -> printBlue(str)
            CONCLUIDO -> printGreen(str)
        }

        return funcaoCor("""
    *****************************************************************************************
    |   FORMAÇÃO
    |   
    |   ID da formação: $idFormacao
    |   Nome da formação: $nomeFormacao
    |   Duração: ${duracao()}H
    |   Situação formação: $situacaoFormacao
    |    
    $conteudosString""")
    }
}