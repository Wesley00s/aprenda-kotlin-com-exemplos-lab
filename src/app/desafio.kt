package app

import entities.Aluno
import entities.Conteudo
import entities.Formacao
import enumeration.Nivel.*
import services.UsuarioService.Companion.alunos
import services.UsuarioService.Companion.menuUsuario
import utility.Util

fun main() {
    executar()
    menuUsuario()
}
fun executar () {
    val conteudo1 = Conteudo(
        BASICO, "CT0001",
        "Princípios da Agilidade e Desenvolvimento Colaborativo",
        "Aprenda a trabalhar em equipe com técnicas de desenvolvimento ágil",
        2
    )

    val conteudo2 = Conteudo(
        BASICO,
        "CT0002",
        "Aprendendo Kotlin na prática com a documentação oficial",
        "Aprenda os princípios básicos do Kotlin diretamente com exemplos práticos da documentação oficial",
        2
    )

    val conteudo3 = Conteudo(
        INTERMEDIARIO,
        "CT0003",
        "Praticando sua lógica de programação com Kotlin",
        "Hora de pôr em prática o conhecimento adquirido até aqui",
        2
    )

    val conteudo4 = Conteudo(
        AVANCADO,
        "CT0004",
        "Desenvolvimento de APIs RESTful com Spring Boot e Kotlin",
        "Aprofunde seus conhecimentos em Kotlin aplicando na criação de APIs RESTful usando o Spring Boot",
        3
    )

    val conteudo5 = Conteudo(
        AVANCADO,
        "CT0005",
        "Testes Unitários e Integração em Projetos Kotlin",
        "Aprenda a realizar testes unitários e de integração em projetos Kotlin",
        3
    )

    val formacao1 = Formacao("FM0001", "Desenvolvimento Backend com Kotlin")
    formacao1.conteudos.add(conteudo1)
    formacao1.conteudos.add(conteudo2)
    formacao1.conteudos.add(conteudo3)

    val formacao2 = Formacao("FM0002", "Desenvolvimento Avançado com Kotlin e Spring Boot")
    formacao2.conteudos.add(conteudo1)
    formacao2.conteudos.add(conteudo2)
    formacao2.conteudos.add(conteudo3)
    formacao2.conteudos.add(conteudo4)
    formacao2.conteudos.add(conteudo5)

    val aluno1 = Aluno("AL${Util.generateID()}", "Julian", "Alves")
    aluno1.addFormacao(formacao1)
    aluno1.addFormacao(formacao2)

    val aluno2 = Aluno("AL${Util.generateID()}", "Maria", "Silva")
    aluno2.addFormacao(formacao2)

    val aluno3 = Aluno("AL${Util.generateID()}", "Carlos", "Santos")
    aluno3.addFormacao(formacao1)

//    println(aluno1.matriculado())
//    println(aluno2.matriculado())
//    println(aluno3.toString())
    alunos.add(aluno1)
    alunos.add(aluno2)
    alunos.add(aluno3)
}