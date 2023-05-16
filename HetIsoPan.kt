import java.util.*

private fun isHeterogram(text: String) =
    text.filter { it.isLetter() }.lowercase(Locale.getDefault()).toSet().size == text.length

private fun isIsogram(text: String): Boolean {
    val letters = text.filter { it.isLetter() }.lowercase(Locale.getDefault())
    return letters.length == letters.toSet().size
}

private fun isPangram(text: String) = text.filter { it.isLetter() }.lowercase(Locale.getDefault()).toSet().size == 26

fun main() {
    println(isHeterogram("hiperblanduzcos"))
    println(isHeterogram("hiperblanduzcós    !!w"))
    println(isIsogram("anna"))
    println(isPangram("The five boxing wizards jump quickly"))
}