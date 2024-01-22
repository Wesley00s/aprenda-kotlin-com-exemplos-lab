package entities

import enumeration.TipoUsuario

open class Usuario(
    val tipoUsuario: TipoUsuario?,
    val id: String,
    val primeiroNome: String,
    val sobrenome: String,
    val senha: String
)