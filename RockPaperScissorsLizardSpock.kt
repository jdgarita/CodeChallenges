import Choice.*

private enum class Choice {
    Rock, Paper, Scissors, Lizard, Spock;

    companion object {
        val relationships = listOf(
            Relationship(Rock, Lizard),
            Relationship(Rock, Scissors),
            Relationship(Paper, Spock),
            Relationship(Paper, Rock),
            Relationship(Scissors, Paper),
            Relationship(Scissors, Lizard),
            Relationship(Spock, Rock),
            Relationship(Spock, Scissors),
            Relationship(Lizard, Paper),
            Relationship(Lizard, Spock)
        )
    }
}

private data class Relationship(val winner: Choice, val loser: Choice)

fun main() {
    val turns = listOf(Pair(Rock, Scissors), Pair(Scissors, Rock), Pair(Paper, Scissors))
    game(turns)
}

/***
 * Rules:
 * s > p
 * p > r
 * r > l
 * l > spock
 * spock > s
 * s > l
 * l > p
 * p > spock
 * spock > r
 * r > s
 */
private fun game(turns: List<Pair<Choice, Choice>>) {
    var player1 = 0
    var player2 = 0
    turns.forEach { turn ->
        val relationship = Choice.relationships.firstOrNull {
            (it.winner == turn.first && it.loser == turn.second) || (it.loser == turn.first && it.winner == turn.second)
        }

        when (relationship) {
            null -> println("It is a draw")
            else -> when (relationship.winner) {
                turn.first -> player1 += 1
                else -> player2 += 1
            }
        }
    }

    when {
        player1 > player2 -> println("Player 1")
        player2 > player1 -> println("Player 2")
        else -> println("tie")
    }
}