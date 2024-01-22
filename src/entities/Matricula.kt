package entities

import java.time.LocalDate

class Matricula(
    val idMatricula: String,
    val dataMatricula: LocalDate,
    val aluno: Aluno,
    val formacao: Formacao
) {
    override fun toString(): String {
        return """
            ID da matrícula: $idMatricula
            Data da matrícula: $dataMatricula
            Aluno: ${aluno.id}
            Formação: ${formacao.id}
            ----------------------------------------
            """
    }
}