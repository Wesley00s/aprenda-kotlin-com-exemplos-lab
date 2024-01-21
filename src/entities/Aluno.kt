package entities

class Aluno (
    id: String,
    primeiroNome: String,
    sobrenome: String,
) : Usuario (id, primeiroNome, sobrenome) {

    private val formacoes : MutableSet<Formacao> = mutableSetOf()

    fun matriculado() : String{
        val resultado = StringBuilder()
        resultado.append("O(a) aluno(a) $primeiroNome de ID = $id, está matriculado(a) nessas formações.\n")
        for (formacao in formacoes) {
            resultado.append("ID da formação: ${formacao.id}\n")
            resultado.append("Conteúdos da formação:\n")
            for (conteudo in formacao.conteudos)
                resultado.append("\tID do conteúdo: ${conteudo.id}\n")
        }
        resultado.append("-----------------------------------------\n")
        return resultado.toString()
    }

    fun addFormacao(formacao: Formacao) {
        formacoes.add(formacao)
    }
}
