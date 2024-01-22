package entities

import java.time.LocalDate

class Certificado (
    val credencial : String,
    val dataDeConclusao : LocalDate,
    val aluno : Aluno,
    val formacao: Formacao
) {
    override fun toString(): String {
        return """
           ***************************************************************
           |                        CERTIFICADO ✅                        |
           *                             *                               *
           |
           |     Certificamos que
           |     ${aluno.primeiroNome.uppercase()} ${aluno.sobrenome.uppercase()}
           |     em $dataDeConclusao, concluiu o curso
           |     ${formacao.nomeFormacao.uppercase()}
           |     com carga horária de ${formacao.duracao()} horas ⌛
           |     
           |      🧑‍🎓 🧠                        - Credencial $credencial
           |
           *                             *                               *
           |                 Certificate CertiExpert 💯                  |
           ***************************************************************
        """
    }
}