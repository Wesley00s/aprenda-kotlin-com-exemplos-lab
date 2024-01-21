package entities;

data class Formacao (
    val id : String,
    val nome: String,
) {
    val conteudos: MutableSet<Conteudo> = mutableSetOf()

    fun duracao(): Int {
        var duracaoTotal = 0
        for (conteudo in conteudos) {
            duracaoTotal += conteudo.duracao
        }
        return duracaoTotal
    }

    private val inscritos = mutableListOf<Usuario>()

    fun matricular (vararg usuarios: Usuario) {
        for (usuario in usuarios) inscritos.add(usuario)
    }
}
