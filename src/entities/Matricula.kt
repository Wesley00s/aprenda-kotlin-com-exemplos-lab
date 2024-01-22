package entities

import java.time.LocalDate

class Matricula(
    val idMatricula: String,
    private val dataMatricula: LocalDate,
    private val aluno: Aluno,
    private val formacao: Formacao?
) {
    override fun toString(): String {
        return """
            ID da matrícula: $idMatricula
            Data da matrícula: $dataMatricula
            Aluno: ${aluno.id}
            Formação: ${formacao?.idFormacao}
            ----------------------------------------
            """
    }
}