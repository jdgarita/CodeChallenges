/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 *
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love
 *   30 - Love
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
 */
fun main() {
    val game = arrayListOf(Player.P1, Player.P1, Player.P2, Player.P2, Player.P1, Player.P2, Player.P1, Player.P1)
    tennis(game)
}

enum class Player {
    P1, P2
}

private fun tennis(game: ArrayList<Player>) {
    val score = mutableListOf<Pair<Int, Int>>()

    var p1Points = 0
    var p2Points = 0

    score.add(0 to 0)
    game.forEach { point ->
        when (point) {
            Player.P1 -> p1Points += 1
            Player.P2 -> p2Points += 1
        }

        when {
            p1Points == p2Points && p1Points >= 3 -> println("Deuce")
            p1Points > (p2Points + 1) && p1Points > 3 -> println("Ha ganado el P1")
            p2Points > (p1Points + 1) && p2Points > 3 -> println("Ha ganado el P2")
            p1Points > p2Points && p1Points > 3 -> println("Ventaja P1")
            p2Points > p1Points && p2Points > 3 -> println("Ventaja P2")
            else -> println("${p1Points.toScore()} - ${p2Points.toScore()}")
        }
    }
}

private fun Int.toScore(): String = when (this) {
    1 -> "15"
    2 -> "30"
    3 -> "40"
    else -> "Love"
}