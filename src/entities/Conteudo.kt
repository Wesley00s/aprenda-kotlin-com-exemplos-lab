package entities

import enumeration.Nivel

data class Conteudo (var nivel : Nivel,
                    val id : String,
                    val nomeConteudo : String,
                    val desc : String,
                    val duracao : Int
)