package services

import entities.Conteudo
import enumeration.Nivel
import enumeration.Nivel.*
import services.AdminService.Companion.menuAdmin
import utility.Util.Companion.generateID
import utility.Util.Companion.printMenu
import utility.Util.Companion.sc

class ConteudoService {
    companion object {
        val conteudos : MutableSet<Conteudo> = mutableSetOf()

        private fun criarConteudo() : Conteudo{
            var nivel : Nivel?
            println("\n\t* ADICIONAR CONTEÚDO\n")
            do {
                printMenu("Informe o nível do conteúdo", "Básico", "Intermediário", "Avançado")
                nivel = when (sc.nextLine()) {
                    "1" -> BASICO
                    "2" -> INTERMEDIARIO
                    "3" -> AVANCADO
                    else -> {
                        println("Opção inválida")
                        null
                    }
                }
            } while (nivel == null)

            var invalido = true
            var nomeConteudo: String
            var desc : String
            var duracao : String

            do {
                println("Informe o nome do conteúdo:")
                nomeConteudo = sc.nextLine()

            } while (nomeConteudo.trim().isEmpty())

            do {
                println("Informe uma descrição do conteúdo:")
                desc = sc.nextLine()

            } while (desc.trim().isEmpty())

            do {
                println("Informe a duração do conteúdo (em horas):")
                duracao = sc.nextLine()

                try {
                    if (duracao.toDouble() <= 0) {
                        println("Informe um valor válido.")
                    } else {
                        invalido = false
                    }
                } catch (e : NumberFormatException) {
                    println("Formato de número não permitido.")
                }

            } while (invalido)

            return Conteudo(nivel, "CT${generateID()}", nomeConteudo, desc, duracao.toDouble())
        }

        fun procurarConteudo() : Conteudo? {
            println("Informe o ID do conteúdo:")
            val idConteudo = sc.nextLine()

            for(conteudo in conteudos) {
                if (conteudo.id == idConteudo) {
                    return conteudo
                }
            }
            return null
        }

        private fun removerConteudo() {
            val conteudo = procurarConteudo()
            if (conteudo != null) {
                conteudos.remove(conteudo)
                println("Conteúdo removido.")
                return
            }
            println("Conteúdo não encontrado.")
        }

        private fun adicionarConteudo() {
            val conteudo = criarConteudo()
            if (conteudo != null) {
                conteudos.add(conteudo)
                println("Conteúdo adicionado.")
                return
            }
            println("Conteúdo não pôde ser adicionado.")
        }

        fun mostrarConteudos() {
            for (conteudo in conteudos) {
                println(conteudo)
            }
        }

        fun menuGerenciarConteudo() {
            while (true) {
                printMenu(
                    "GERENCIAR CONTEÚDO - O que deseja?",
                    "Adicionar conteúdo",
                    "Remover conteúdo",
                    "Procurar conteúdo",
                    "Mostrar lista de conteúdos",
                    "Voltar"
                )
                when (sc.nextLine()) {
                    "1" -> adicionarConteudo()
                    "2" -> removerConteudo()
                    "3" -> println(procurarConteudo() ?: "\nNão foi possível encontrar o conteúdo.")
                    "4" -> mostrarConteudos()
                    "5" -> menuAdmin()
                    else -> println("Opção inválida.")
                }
            }
        }
    }
}