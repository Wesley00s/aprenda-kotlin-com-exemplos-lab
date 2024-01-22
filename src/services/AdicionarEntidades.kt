package services;

import entities.Aluno
import entities.Conteudo
import entities.Formacao
import enumeration.Nivel.*
import services.AdminService.Companion.usuarios
import services.AlunoService.Companion.fazerMatricula
import services.ConteudoService.Companion.conteudos
import services.FormacaoService.Companion.formacoes

public class AdicionarEntidades {
    companion object {
        fun adicaoTeste() {
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

            val copiaConteudo1 = Conteudo(
                BASICO, "CT302468317",
                "Princípios da Agilidade e Desenvolvimento Colaborativo",
                "Aprenda a trabalhar em equipe com técnicas de desenvolvimento ágil",
                1.5
            )
            val copiaConteudo1_2 = Conteudo(
                BASICO, "CT302468317",
                "Princípios da Agilidade e Desenvolvimento Colaborativo",
                "Aprenda a trabalhar em equipe com técnicas de desenvolvimento ágil",
                1.5
            )
            val copiaConteudo1_2_2 = Conteudo(
                BASICO, "CT302468317",
                "Princípios da Agilidade e Desenvolvimento Colaborativo",
                "Aprenda a trabalhar em equipe com técnicas de desenvolvimento ágil",
                1.5
            )


            val copiaConteudo2 = Conteudo(
                BASICO,
                "CT541965002",
                "Aprendendo Kotlin na prática com a documentação oficial",
                "Aprenda os princípios básicos do Kotlin diretamente com exemplos práticos da documentação oficial",
                2.0
            )
            val copiaConteudo2_2 = Conteudo(
                BASICO,
                "CT541965002",
                "Aprendendo Kotlin na prática com a documentação oficial",
                "Aprenda os princípios básicos do Kotlin diretamente com exemplos práticos da documentação oficial",
                2.0
            )
            val copiaConteudo2_2_2 = Conteudo(
                BASICO,
                "CT541965002",
                "Aprendendo Kotlin na prática com a documentação oficial",
                "Aprenda os princípios básicos do Kotlin diretamente com exemplos práticos da documentação oficial",
                2.0
            )


            val copiaConteudo3 = Conteudo(
                INTERMEDIARIO,
                "CT123888047",
                "Praticando sua lógica de programação com Kotlin",
                "Hora de pôr em prática o conhecimento adquirido até aqui",
                2.0
            )
            val copiaConteudo3_2 = Conteudo(
                INTERMEDIARIO,
                "CT123888047",
                "Praticando sua lógica de programação com Kotlin",
                "Hora de pôr em prática o conhecimento adquirido até aqui",
                2.0
            )
            val copiaConteudo3_2_2 = Conteudo(
                INTERMEDIARIO,
                "CT123888047",
                "Praticando sua lógica de programação com Kotlin",
                "Hora de pôr em prática o conhecimento adquirido até aqui",
                2.0
            )

            val copiaConteudo4 = Conteudo(
                AVANCADO,
                "CT654011987",
                "Desenvolvimento de APIs RESTful com Spring Boot e Kotlin",
                "Aprofunde seus conhecimentos em Kotlin aplicando na criação de APIs RESTful usando o Spring Boot",
                3.0
            )

            val copiaConteudo5 = Conteudo(
                AVANCADO,
                "CT445732011",
                "Testes Unitários e Integração em Projetos Kotlin",
                "Aprenda a realizar testes unitários e de integração em projetos Kotlin",
                3.2
            )

            val formacao1 = Formacao("FM411669010", "Desenvolvimento Backend com Kotlin")
            formacao1.conteudos = mutableSetOf(conteudo1, conteudo2, conteudo3)

            val copiaFormacao1 = Formacao("FM411669010", "Desenvolvimento Backend com Kotlin")
            copiaFormacao1.conteudos = mutableSetOf(copiaConteudo1, copiaConteudo2, copiaConteudo3)

            val copiaFormacao1_2 = Formacao("FM411669010", "Desenvolvimento Backend com Kotlin")
            copiaFormacao1_2.conteudos = mutableSetOf(copiaConteudo1_2, copiaConteudo2_2, copiaConteudo3_2)

            val formacao2 = Formacao("FM922004404", "Desenvolvimento Avançado com Kotlin e Spring Boot")
            formacao2.conteudos = mutableSetOf(conteudo1, conteudo2, conteudo3, conteudo4, conteudo5)

            val copiaFormacao2 = Formacao("FM922004404", "Desenvolvimento Avançado com Kotlin e Spring Boot")
            val copiaFormacao2_2 = Formacao("FM922004404", "Desenvolvimento Avançado com Kotlin e Spring Boot")
            copiaFormacao2.conteudos =
                mutableSetOf(copiaConteudo1_2_2, copiaConteudo2_2_2, copiaConteudo3_2_2, copiaConteudo4, copiaConteudo5)

            formacoes.add(formacao1)
            formacoes.add(formacao2)

            val aluno1 = Aluno("AL545669084", "Julian", "Alves", "minhaSenha")
            fazerMatricula(aluno1, copiaFormacao1)
            fazerMatricula(aluno1, copiaFormacao2)

            val aluno2 = Aluno("AL781079031", "Maria", "Silva", "segura123")
            fazerMatricula(aluno2, copiaFormacao1_2)

            val aluno3 = Aluno("AL757169038", "Carlos", "Santos", "senhaSegura")
            fazerMatricula(aluno3, copiaFormacao2_2)

            usuarios.add(aluno1)
            usuarios.add(aluno2)
            usuarios.add(aluno3)
        }
    }
}
