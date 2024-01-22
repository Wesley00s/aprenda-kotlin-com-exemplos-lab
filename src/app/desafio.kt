package app

import entities.Aluno
import entities.Conteudo
import entities.Formacao
import entities.Matricula
import enumeration.Nivel.*
import services.AdminService
import services.ConteudoService.Companion.conteudos
import services.FormacaoService.Companion.formacoes
import services.AdminService.Companion.adicionarPrimeiroAdmin
import services.AdminService.Companion.menuLoginAdmin
import services.AdminService.Companion.usuarios
import services.AlunoService.Companion.menuLoginAluno
import utility.Util
import kotlin.system.exitProcess

fun main() {
    adicionarPrimeiroAdmin()
    executar()
    menuUsuarios()
}

fun menuUsuarios() {
    while (true) {
        Util.printMenu("MENU DE USUÁRIOS - Qual tipo de usuário você é?", "Administrador", "Aluno", "Sair")
        when (Util.sc.nextLine()) {
            "1" -> menuLoginAdmin()
            "2" -> menuLoginAluno()
            "3" -> exitProcess(0)
            else -> println("Tipo de usuário inválido.")
        }
    }
}

fun executar () {
    val conteudo1 = Conteudo(
        BASICO, "CT302468317",
        "Princípios da Agilidade e Desenvolvimento Colaborativo",
        "Aprenda a trabalhar em equipe com técnicas de desenvolvimento ágil",
        1.5
    )

    val conteudo2 = Conteudo(
        BASICO,
        "CT541965002",
        "Aprendendo Kotlin na prática com a documentação oficial",
        "Aprenda os princípios básicos do Kotlin diretamente com exemplos práticos da documentação oficial",
        2.0
    )

    val conteudo3 = Conteudo(
        INTERMEDIARIO,
        "CT123888047",
        "Praticando sua lógica de programação com Kotlin",
        "Hora de pôr em prática o conhecimento adquirido até aqui",
        2.0
    )

    val conteudo4 = Conteudo(
        AVANCADO,
        "CT654011987",
        "Desenvolvimento de APIs RESTful com Spring Boot e Kotlin",
        "Aprofunde seus conhecimentos em Kotlin aplicando na criação de APIs RESTful usando o Spring Boot",
        3.0
    )

    val conteudo5 = Conteudo(
        AVANCADO,
        "CT445732011",
        "Testes Unitários e Integração em Projetos Kotlin",
        "Aprenda a realizar testes unitários e de integração em projetos Kotlin",
        3.2
    )

    conteudos.add(conteudo1)
    conteudos.add(conteudo2)
    conteudos.add(conteudo3)
    conteudos.add(conteudo4)
    conteudos.add(conteudo5)

    val formacao1 = Formacao("FM411669010", "Desenvolvimento Backend com Kotlin")
    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)
    formacao1.adicionarConteudo(conteudo3)

    val formacao2 = Formacao("FM922004404", "Desenvolvimento Avançado com Kotlin e Spring Boot")
    formacao2.adicionarConteudo(conteudo1)
    formacao2.adicionarConteudo(conteudo2)
    formacao2.adicionarConteudo(conteudo3)
    formacao2.adicionarConteudo(conteudo4)
    formacao2.adicionarConteudo(conteudo5)

    formacoes.add(formacao1)
    formacoes.add(formacao2)

    val aluno1 = Aluno("AL545669084", "Julian", "Alves", "minhaSenha")
    aluno1.addFormacao(formacao1)
    aluno1.addFormacao(formacao2)

    val aluno2 = Aluno("AL781079031", "Maria", "Silva", "segura123")
    aluno2.addFormacao(formacao1)

    val aluno3 = Aluno("AL757169038", "Carlos", "Santos", "senhaSegura")
    aluno3.addFormacao(formacao2)

    usuarios.add(aluno1)
    usuarios.add(aluno2)
    usuarios.add(aluno3)
}