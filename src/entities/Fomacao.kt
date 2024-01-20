package entities;

data class Formacao (val nome: String, val conteudos: List<Conteudo>) {

    fun duracao(): Int {
        var duracaoTotal = 0
        for (conteudo in conteudos) {
            duracaoTotal += conteudo.duracao
        }
        return duracaoTotal
    }

    private val inscritos = mutableListOf<Usuario>()

    fun matricular (usuario: Usuario) {
        inscritos.add(usuario)
    }
}
