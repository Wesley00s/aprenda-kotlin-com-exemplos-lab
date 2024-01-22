package entities

import enumeration.TipoUsuario.ALUNO

class Aluno (
    id: String,
    primeiroNome: String,
    sobrenome: String,
    senha : String
) : Usuario (ALUNO, id, primeiroNome, sobrenome, senha) {

    private val formacoes  = mutableSetOf<Formacao>()
    val certificados = mutableSetOf<Certificado>()

    fun addFormacao(formacao: Formacao) {
        formacoes.add(formacao)
    }

    fun verMinhasFormacoes() {
        println("\n\t\t* MINHAS FORMAÇÕES")

        for (formacao in formacoes) {
            println(formacao)
        }
    }

    fun adicionarCertificado(certificado: Certificado) {
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
