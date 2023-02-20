fun main() {
    val turns = listOf(Pair("O", "X"), Pair("X", "O"), Pair("[]", "X"))
    game(turns)
}

private fun game(turns: List<Pair<String, String>>) {

    val rules = mapOf(
        Pair("O", listOf("️X", "S")),
        Pair("[]", listOf("️O", "W")),
        Pair("X", listOf("️[]", "S")),
        Pair("S", listOf("️W", "[]")),
        Pair("W", listOf("️O", "X"))
    )
    var player1 = 0
    var player2 = 0

    turns.forEach { turn ->
        val player1Game = turn.first
        val player2Game = turn.second

        if (player1Game != player2Game) {
            if (rules[player1Game]?.contains(player2Game) == true) {
                player1 += 1
            } else {
                player2 += 1
            }
        }
    }

    when {
        player1 > player2 -> println("Player 1")
        player2 > player1 -> println("Player 2")
        else -> println("tie")
    }
}