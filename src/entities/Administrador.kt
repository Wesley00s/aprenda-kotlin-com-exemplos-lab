package entities

import enumeration.TipoUsuario.ADMINISTRADOR

class Administrador(
    id: String,
    primeiroNome: String,
    sobrenome: String,
    senha : String
) : Usuario (ADMINISTRADOR, id, primeiroNome, sobrenome, senha) {
    override fun toString(): String {
        return """
            ID do administrador: $id
            Nome do administrador $primeiroNome $sobrenome
            Senha do administrador: $senha
            ---------------------------------------------
        """
    }
}