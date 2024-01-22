package services

import app.menuUsuarios
import entities.Administrador
import entities.Aluno
import entities.Matricula
import entities.Usuario
import enumeration.TipoUsuario
import enumeration.TipoUsuario.*
import services.AlunoService.Companion.matriculas
import services.ConteudoService.Companion.menuGerenciarConteudo
import services.FormacaoService.Companion.menuGerenciarFormacoes
import utility.Util.Companion.generateID
import utility.Util.Companion.printMenu
import utility.Util.Companion.sc

class AdminService {
    companion object {
        val usuarios : MutableList<Usuario> = mutableListOf()

        fun adicionarPrimeiroAdmin() {
            val admin = Administrador("AD${generateID()}", "a", "a", "1")
            usuarios.add(admin)
        }

        private fun criarUsuario(tipoUsuario: TipoUsuario) : Usuario {
            println("\n\t* CADASTRO DE ${tipoUsuario}\n")

            var primeiroNome : String
            var sobrenome : String
            var senha : String

            do {
                print("Primeiro nome: ")
                primeiroNome = sc.nextLine()

            } while (primeiroNome.trim().isEmpty())

            do {
                print("Sobrenome: ")
                sobrenome = sc.nextLine()

            } while (sobrenome.trim().isEmpty())

            do {
                print("Defina uma senha: ")
                senha = sc.nextLine()

            } while (senha.trim().isEmpty())

            return when (tipoUsuario) {
                ALUNO -> Aluno("AL${generateID()}", primeiroNome, sobrenome, senha)
                ADMINISTRADOR -> Administrador("AD${generateID()}", primeiroNome, sobrenome, senha)
            }
        }

        private fun loginAdmin() {
            println("\n\t* LOGIN DE ADMINISTRADOR\n")

            print("Informe o nome completo: ")
            val nomeCompleto : String = sc.nextLine().uppercase()

            print("Informe a senha: ")
            val senha : String = sc.nextLine()

            for (usuario in usuarios) {
                if (usuario.tipoUsuario == ADMINISTRADOR
                    && nomeCompleto == ("${usuario.primeiroNome.uppercase()} ${usuario.sobrenome.uppercase()}")
                    && usuario.senha == (senha)) {

                    println("Logado com sucesso!")
                    menuAdmin()
                }
            }
            println("Combinação de nome e senha não correspondente.")
        }



        private fun mostrarAlunos() {
            for (aluno in usuarios) {
                println("ID: ${aluno.id}")
                println("Nome: ${aluno.primeiroNome} ${aluno.sobrenome}\n")
            }
        }

        private fun procurarUsuario(tipoUsuario: TipoUsuario) : Usuario? {
            println("\nInforme o ID do $tipoUsuario")
            val id = sc.nextLine()
            for (usuario in usuarios) {
                if (usuario.tipoUsuario == tipoUsuario && usuario.id == (id)) {
                    return usuario
                }
            }
            return null
        }

        private fun removerUsuario(tipoUsuario: TipoUsuario) {
            println("\n\t* REMOVER $tipoUsuario\n")

            val usuario = procurarUsuario(tipoUsuario)
            if (usuario != null) {
                usuarios.remove(usuario)
                println("$tipoUsuario removido.")
                return
            }
            println("$tipoUsuario não encontrado.")
        }

        private fun verListaDeUsuarios(tipoUsuario: TipoUsuario) {
            for (usuario in usuarios) {
                if (usuario.tipoUsuario == tipoUsuario) println(usuario)
            }
        }

        private fun gerenciarUsuarios(tipoUsuario: TipoUsuario) {
            while (true) {
                printMenu(
                    "GERENCIAR ${if (tipoUsuario == ALUNO) "ALUNOS" else "ADMINISTRADORES"} - Escolha uma opção",
                    "Cadastrar $tipoUsuario",
                    "Remover $tipoUsuario",
                    "Ver lista de ${if (tipoUsuario == ALUNO) "Alunos" else "Administradores"}",
                    "Voltar"
                )
                when (sc.nextLine()) {
                    "1" -> adicionarUsuario(tipoUsuario)
                    "2" -> removerUsuario(tipoUsuario)
                    "3" -> verListaDeUsuarios(tipoUsuario)
                    "4" -> menuGerenciarUsuarios()
                    else -> println("Opção inválida.")
                }
            }
        }

        private fun menuGerenciarUsuarios() {
            while (true) {
                printMenu(
                    "MENU GERENCIAR USUÁRIOS - O que deseja?",
                    "Gerenciar administradores",
                    "Gerenciar alunos",
                    "Voltar"
                )
                when (sc.nextLine()) {
                    "1" -> gerenciarUsuarios(ADMINISTRADOR)
                    "2" -> gerenciarUsuarios(ALUNO)
                    "3" -> menuAdmin()
                    else -> println("Opção inválida.")
                }
            }
        }

        fun menuAdmin() {
            while (true) {
                printMenu(
                    "MENU DE ADMINISTRADOR - Olá caro admin, o que deseja?",
                    "Conteúdos",
                    "Formações",
                    "Usuários",
                    "Matrículas",
                    "Voltar ao menu de usuários")
                when (sc.nextLine()) {
                    "1" -> menuGerenciarConteudo()
                    "2" -> menuGerenciarFormacoes()
                    "3" -> menuGerenciarUsuarios()
                    "4" -> gerenciarMatricula()
                    "5" -> menuUsuarios()
                    else -> println("Opção inválida.")
                }
            }
        }

        private fun gerenciarMatricula() {
            while (true) {
                printMenu(
                    "GERENCIAR MATRÍCULAS - Escolha uma opção",
                    "Ver lista de matrículas",
                    "Procurar matrícula",
                    "Voltar")
                when (sc.nextLine()) {
                    "1" -> verListaDeMatricula()
                    "2" -> println(procurarMatricula() ?: "Matricula não encontrada")
                    "3" -> menuAdmin()
                    else -> println("Opção inválida.")
                }
            }
        }

        private fun procurarMatricula() : Matricula? {
            println("Informe o ID da matrícula:")
            val idMatricula = sc.nextLine()

            for (matricula in matriculas) {
                if (matricula.idMatricula == idMatricula) {
                    return matricula
                }
            }
            return null
        }

        private fun verListaDeMatricula() {
            for (matricula in matriculas) {
                println(matricula)
            }
        }

        fun adicionarUsuario(tipoUsuario: TipoUsuario) {
            val usuario = criarUsuario(tipoUsuario)
            if (usuario != null) {
                usuarios.add(usuario)
                println("Usuário adicionado.")
                return
            }
            println("Usuário não pôde ser adicionado.")
        }

        fun menuLoginAdmin() {
            while (true) {
                printMenu("MENU DE LOGIN DE ADMINISTRADOR - Olá admin, o que deseja?",  "Login", "Voltar")
                when (sc.nextLine()) {
                    "1" -> loginAdmin()
                    "2" -> menuUsuarios()
                    else -> println("Opção inválida.")
                }
            }
        }
    }
}
