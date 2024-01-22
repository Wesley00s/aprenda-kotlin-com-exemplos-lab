package entities

import enumeration.Situacao.*
import enumeration.TipoUsuario.ALUNO
import utility.Util.Companion.generateID
import utility.Util.Companion.sc
import java.time.LocalDate

class Aluno (
    id: String,
    primeiroNome: String,
    sobrenome: String,
    senha : String
) : Usuario (ALUNO, id, primeiroNome, sobrenome, senha) {

    private val alunoFormacoes  = mutableSetOf<Formacao>()
    val certificados = mutableSetOf<Certificado>()

    fun addFormacao(formacao: Formacao) {
        alunoFormacoes.add(formacao)
    }

    fun getFormacao(idFormacao: String): Formacao? {
        return alunoFormacoes.find { it.idFormacao == idFormacao }
    }

    fun estudarFormacao() {
        println("\n\t* ESTUDAR FORMAÇÃO\n")
        println("Informe o ID da formação:")
        val id = sc.nextLine()
        var encontrarFormacao = false
        var formacaoAluno : Formacao? = null
        for (f in alunoFormacoes) {
            if (f.idFormacao == id) {
                formacaoAluno = f
                encontrarFormacao = true
                break
            }
        }
        if (!encontrarFormacao) {
            println("Você não está matriculado(a) nessa formação.")
        }

        if (formacaoAluno != null) {

            for (conteudo in formacaoAluno.conteudos) {
                if (conteudo.situacaoConteudo == PENDENTE) {
                    println("\n\tEstudando ${conteudo.nomeConteudo}...\n")
                    Thread.sleep(3000)

                    conteudo.concluirConteudo()
                    println("Estudo do conteúdo '${conteudo.nomeConteudo}' concluído.")

                    if (formacaoAluno.conteudos.all { it.situacaoConteudo == CONCLUIDO }) {
                        println("\nParabéns! Você concluiu a formação '${formacaoAluno.nomeFormacao}'.")
                        formacaoAluno.situacaoFormacao = CONCLUIDO

                        val certificado = Certificado("CRD${generateID()}", LocalDate.now(), this, formacaoAluno)
                        println("\n\t* CERTIFICADO DE CONCLUSÃO")
                        println(certificado)
                        adicionarCertificado(certificado)
                    }
                    return
                }
            }
        }
    }

    fun verMinhasFormacoes() {
        println("\n\t\t* MINHAS FORMAÇÕES")

        for (formacao in alunoFormacoes) {
            println(formacao)
        }
    }

    private fun adicionarCertificado(certificado: Certificado) {
        certificados.add(certificado)
    }

    override fun toString(): String {
        return """
            ID do aluno: $id
            Nome do aluno: $primeiroNome $sobrenome
            Senha: $senha
            ----------------------------------------"""
    }
}
