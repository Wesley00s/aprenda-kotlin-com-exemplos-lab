package entities

import java.time.LocalDate

class Certificado(
    private val credencial: String,
    private val dataDeConclusao: LocalDate,
    private val aluno: Aluno,
    private val formacao: Formacao?
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
           |     ${formacao?.nomeFormacao?.uppercase()}
           |     com carga horária de ${formacao?.duracao()} horas ⌛
           |     
           |      🧑‍🎓 🧠                        - Credencial $credencial
           |
           *                             *                               *
           |                 Certificate CertiExpert 💯                  |
           ***************************************************************
        """
    }
}