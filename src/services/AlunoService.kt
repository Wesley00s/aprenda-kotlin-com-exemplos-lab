package services

import app.menuUsuarios
import entities.Aluno
import entities.Conteudo
import entities.Formacao
import entities.Matricula
import enumeration.TipoUsuario.*
import services.AdminService.Companion.adicionarUsuario
import services.AdminService.Companion.usuarios
import services.FormacaoService.Companion.procurarFormacao
import services.FormacaoService.Companion.verListaDeFormacoes
import utility.Util
import utility.Util.Companion.generateID
import utility.Util.Companion.printMenu
import utility.Util.Companion.sc
import java.time.LocalDate

class AlunoService {
    companion object {
        val matriculas = mutableSetOf<Matricula>()
        fun menuLoginAluno() {
            while (true) {
                printMenu("LOGIN DO ALUNO - Olá aluno, o que deseja?", "Fazer cadastro", "Login", "Voltar")
                when (Util.sc.nextLine()) {
                    "1" -> adicionarUsuario(ALUNO)
                    "2" -> loginAluno()
                    "3" -> menuUsuarios()
                    else -> println("Opção inválida.")
                }
            }
        }

        private fun menuAluno(aluno: Aluno) {
            while (true) {
                printMenu(
                    "MENU DE ALUNO - Olá caro aluno, o que deseja?",
                    "Fazer matrícula",
                    "Ver formações",
                    "Ver minhas formações",
                    "Estudar formação",
                    "Procurar formação",
                    "Ver meus certificados",
                    "Voltar ao menu de usuários"
                )
                when (sc.nextLine()) {
                    "1" -> {
                        println("\n\t* FAZER MATRÍCULA\n")

                        println("Informe a formação em que deseja se matricular.")
                        val formacao = procurarFormacao()

                        if (formacao != null) {
                            val copiaFormacao = Formacao(formacao.idFormacao, formacao.nomeFormacao)
                            for (f in formacao.conteudos) {
                                copiaFormacao.adicionarConteudo(Conteudo(f.nivel, f.id, f.nomeConteudo, f.desc, f.duracao))
                            }
                            adicionarMatricula(fazerMatricula(aluno, copiaFormacao))
                            println("Matrícula feita com sucesso.")
                        } else {
                            println("A matrícula não pôde ser feita.")
                        }

                    }
                    "2" -> verListaDeFormacoes()
                    "3" -> aluno.verMinhasFormacoes()
                    "4" -> aluno.estudarFormacao()
                    "5" -> procurarFormacao()
                    "6" -> verMeusCertificados(aluno)
                    "7" -> menuUsuarios()
                    else -> println("Opção inválida.")
                }
            }
        }

        private fun verMeusCertificados(aluno: Aluno) {
            for (certificado in aluno.certificados) {
                println(certificado)
            }
        }

        private fun adicionarMatricula(matricula: Matricula) {
            matriculas.add(matricula)
        }

        fun fazerMatricula(aluno: Aluno, formacao: Formacao): Matricula {
            val matricula = Matricula("MT${generateID()}", LocalDate.now(), aluno, formacao)
            aluno.addFormacao(formacao)
            matriculas.add(matricula)
            return matricula
        }

        private fun loginAluno() {
            println("\n\t* LOGIN DE ALUNO\n")

            print("Informe o nome completo: ")
            val nomeCompleto : String = sc.nextLine().uppercase()

            print("Informe a senha: ")
            val senha : String = sc.nextLine()

            for (usuario in usuarios) {
                if (usuario.tipoUsuario == ALUNO
                    && nomeCompleto == ("${usuario.primeiroNome.uppercase()} ${usuario.sobrenome.uppercase()}")
                    && usuario.senha == (senha)) {

                    println("Logado com sucesso!")
                    menuAluno(usuario as Aluno)
                }
            }
            println("Combinação de nome e senha não correspondente.")
        }
    }
}