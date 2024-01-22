package app

import services.AdicionarEntidades.Companion.adicaoTeste
import services.AdminService.Companion.adicionarPrimeiroAdmin
import services.AdminService.Companion.menuLoginAdmin
import services.AlunoService.Companion.menuLoginAluno
import utility.Util
import kotlin.system.exitProcess

fun main() {
    adicionarPrimeiroAdmin()
    adicaoTeste()
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