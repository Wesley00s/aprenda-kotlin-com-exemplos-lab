package services;

import entities.Formacao
import services.ConteudoService.Companion.conteudos
import services.ConteudoService.Companion.mostrarConteudos
import services.ConteudoService.Companion.procurarConteudo
import services.AdminService.Companion.menuAdmin
import utility.Util.Companion.generateID
import utility.Util.Companion.printMenu
import utility.Util.Companion.sc

class FormacaoService {
    companion object{
        val formacoes = mutableSetOf<Formacao>()

        fun menuGerenciarFormacoes() {
            while (true) {
                printMenu(
                    "GERENCIAR FORMAÇÕES - Escolha uma opção",
                    "Adicionar formação",
                    "Remover formação",
                    "Adicionar conteúdo na formação",
                    "Ver lista de formações",
                    "Procurar formação",
                    "Voltar"
                )
                when (sc.nextLine()) {
                    "1" -> adicionarFormacao()
                    "2" -> removerFormacao()
                    "3" -> adicionarConteudos()
                    "4" -> verListaDeFormacoes()
                    "5" -> println(procurarFormacao() ?: "Não foi prossível encontrar formação.")
                    "6" -> menuAdmin()
                    else -> println("Opção inválida.")
                }
            }
        }

        fun verListaDeFormacoes() {
            for (formacao in formacoes) {
                println(formacao)
            }
        }

        private fun adicionarFormacao() {
            val formacao = criarFormacao();
            if (formacao != null) {
                formacoes.add(formacao)
                println("Formação adicionada.")
                return
            }
            println("Não foi possível adicionar formação.")
        }

        private fun removerFormacao() {
            val formacao = procurarFormacao();
            if (formacao != null) {
                formacoes.remove(formacao)
                println("Formação removida.")
                return
            }
            println("Não foi possível remover formação.")
        }

        private fun criarFormacao() : Formacao {
            var nome : String
            do {
                println("Informe o nome da formação:")
                nome = sc.nextLine()

            } while (nome.trim().isEmpty())

            return Formacao("FM${generateID()}", nome)
        }

        fun procurarFormacao() : Formacao? {
            println("Informe o ID da formação:")
            val idFormacao = sc.nextLine()

            for (formacao in formacoes) {
                if (formacao.id == idFormacao) {
                    return formacao
                }
            }
            println("Formação não encontrada.")
            return null
        }

        private fun adicionarConteudoNaFormacao(formacao: Formacao) {
            println("ID do conteúdo:")
            val idConteudo = sc.nextLine()

            for (conteudo in conteudos) {
                if (conteudo.id == idConteudo) {
                    formacao.adicionarConteudo(conteudo)
                    println("Conteúdo adicionado.")
                    return
                }
            }
            println("Não foi possível adicionar conteúdo.")
        }

        private fun adicionarConteudos() {
            println("\n\t* ADICIONAR CONTEÚDO NA FORMAÇÃO\n")

            println("Formação que deseja adicionar o conteúdo.")
            val formacao = procurarFormacao()
            if (formacao != null) {
                while (true) {
                    printMenu("Informe os conteúdos que deseja adicionar",
                        "Adicionar conteúdo a formação",
                        "Procurar conteudo",
                        "Ver lista de conteudos",
                        "Voltar")
                    when (sc.nextLine()) {
                        "1" -> adicionarConteudoNaFormacao(formacao)
                        "2" -> println(procurarConteudo() ?: "Não foi possível encontrar formação")
                        "3" -> mostrarConteudos()
                        "4" -> break
                    }
                }
            }
        }
    }
}
