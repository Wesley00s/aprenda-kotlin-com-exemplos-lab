package utility

import java.util.*
import java.util.Locale.getDefault

class Util {
    companion object {
        private val idSet : MutableSet<Int> = mutableSetOf()
        fun generateID() : String {
            var id : Int
            do {
                val random = Random()
                id = random.nextInt(99999999, 999999999)
            } while (!idSet.add(id))
            return "$id"
        }

        val sc =  Scanner(System.`in`)
        fun printMenu(mensagem: String, vararg opcoes: String) {
            val replace = mensagem.map { '-' }.joinToString("")

            println("""
    ------$replace------
         $mensagem
    ------$replace------"""
            )

            var cont = 1
            for (opcao in opcoes) {
                println("\t>>    (  ${cont++}  )   ${opcao.uppercase(getDefault())}")
            }

            println("\t------$replace------")
            print("\t>> ")
        }
    }
}