package entities;

import enumeration.Situacao
import enumeration.Situacao.*
import utility.Util.Companion.printGreen
import utility.Util.Companion.printBlue

data class Formacao (
    val id: String,
    val nomeFormacao: String,
) {
    var situacaoFormacao : Situacao = EM_ANDAMENTO

    private val conteudos = mutableSetOf<Conteudo>()
    private val inscritos = mutableSetOf<Usuario>()

    fun duracao(): Double {
        var duracaoTotal = 0.0
        for (conteudo in conteudos) {
            duracaoTotal += conteudo.duracao
        }
        return duracaoTotal
    }

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun estudarFormacao() {
        if (conteudos.isEmpty()) {
            println("A formação não possui conteúdos.")
            return
        }
        if (situacaoFormacao == CONCLUIDO) {
            println("A formação já foi concluída.")
            return
        }

        for (conteudo in conteudos) {
            if (conteudo.situacaoConteudo == EM_ANDAMENTO) {
                conteudo.concluirConteudo()
                println("Estudo do conteúdo '${conteudo.nomeConteudo}' concluído.")
                if(conteudos.last() == conteudo) {
                    println("Parabéns! Você concluiu a formação '${nomeFormacao}'.")
                    situacaoFormacao = CONCLUIDO
                }
                break
            }
        }
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
            EM_ANDAMENTO -> printBlue(str)
            CONCLUIDO -> printGreen(str)
        }

        return funcaoCor("""
    *****************************************************************************************
    |   FORMAÇÃO
    |   
    |   ID da formação: $id
    |   Nome da formação: $nomeFormacao
    |   Duração: ${duracao()}H
    |   Total de inscritos: ${inscritos.size}
    |   Situação formação: $situacaoFormacao
    |    
    $conteudosString""")
    }
}