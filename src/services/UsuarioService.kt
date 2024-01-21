package services

import entities.Aluno
import utility.Util.Companion.generateID
import utility.Util.Companion.printMenu
import utility.Util.Companion.sc
import kotlin.system.exitProcess

class UsuarioService {
    companion object {
        val alunos : MutableList<Aluno> = mutableListOf()
        private fun cadastrarAluno() : Aluno {
            println("\n\t* CADASTRO DE ALUNO\n")

            print("Primeiro nome: ")
            val primeiroNome = sc.nextLine()

            print("Sobrenome: ")
            val sobrenome = sc.nextLine()

            return Aluno("AL${generateID()}", primeiroNome, sobrenome)
        }

        private fun mostrarAlunos() {
            for (aluno in alunos) {
                println("ID: ${aluno.id}")
                println("Nome: ${aluno.primeiroNome} ${aluno.sobrenome}\n")
            }
        }

        fun menuUsuario() {
            while (true) {
                printMenu("Olá usuário, o que deseja?", "Cadastrar aluno", "Ver alunos", "Sair")
                when (sc.nextLine()) {
                    "1" -> alunos.add(cadastrarAluno())
                    "2" -> mostrarAlunos()
                    "3" -> exitProcess(0)
                }
            }
        }
    }
}
