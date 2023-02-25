fun main() {
    startCeremony()
}

data class HatQuestion(val question: String, val answers: List<Pair<String, House>>)
enum class House {
    Gryffindor, Ravenclaw, Hufflepuff, Slytherin
}

val hatQuestions = listOf(
    HatQuestion(
        question = "¿Cómo te definirías?", answers = listOf(
            Pair("1. Valiente", House.Gryffindor),
            Pair("2. Leal", House.Hufflepuff),
            Pair("3. Sabio", House.Ravenclaw),
            Pair("4. Ambicioso", House.Slytherin),
        )
    ), HatQuestion(
        question = "¿Cuál es tu clase favorita?", answers = listOf(
            Pair("1. Vuelo", House.Gryffindor),
            Pair("3. Pociones", House.Ravenclaw),
            Pair("4. Defensa contra las artes oscuras", House.Slytherin),
            Pair("2. Animales fantásticos", House.Hufflepuff),
        )
    ), HatQuestion(
        question = "¿Dónde pasarías más tiempo?", answers = listOf(
            Pair("2. Invernadero", House.Hufflepuff),
            Pair("3. Biblioteca", House.Ravenclaw),
            Pair("4. En la sala común", House.Slytherin),
            Pair("1. Explorando", House.Gryffindor),
        )
    ), HatQuestion(
        question = "¿Cuál es tu color favorito?", answers = listOf(
            Pair("1. Rojo", House.Gryffindor),
            Pair("3. Azul", House.Ravenclaw),
            Pair("4. Verde", House.Slytherin),
            Pair("2. Amarillo", House.Hufflepuff),
        )
    ), HatQuestion(
        question = "¿Cuál es tu mascota?", answers = listOf(
            Pair("3. Sapo", House.Ravenclaw),
            Pair("1. Lechuza", House.Gryffindor),
            Pair("2. Gato", House.Hufflepuff),
            Pair("4. Serpiente", House.Slytherin),
        )
    )
)

val houses = mutableMapOf(
    Pair(House.Gryffindor, 0), Pair(House.Hufflepuff, 0), Pair(House.Ravenclaw, 0), Pair(House.Slytherin, 0)
)

private fun getAnswer(): Int? {
    println("Responde 1, 2, 3 o 4: ")
    val answer = readln()
    if (answer.toInt() in 1..4) {
        return answer.toInt()
    }
    return null
}

private fun validateAnswer(answerId: Int?, answers: List<Pair<String, House>>) {
    if (answerId != null) {
        val house = answers[answerId - 1].second
        houses[house] = houses[house]!! + 1
    } else {
        getAnswer()
    }
}

private fun retrieveHouse() {
    val maxPoints = houses.values.maxOrNull() ?: 0

    val housesWithMaxPoints = houses.entries.filter { it.value == maxPoints }

    if (housesWithMaxPoints.size == 1) {
        println("Lo tengo claro... ¡${housesWithMaxPoints[0].key}!")
    } else {
        println("Ha estado complicado... ¡${housesWithMaxPoints.random().key}!")
    }
}

fun startCeremony() {
    hatQuestions.forEach { hatQuestion ->
        println(hatQuestion.question)
        hatQuestion.answers.forEach { answer ->
            println(answer.first)
        }
        validateAnswer(getAnswer(), answers = hatQuestion.answers)
    }
    retrieveHouse()
}