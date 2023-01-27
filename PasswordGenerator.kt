fun main() {
    println(
        generatePassword(
            isWithUppercase = false, isWithNumbers = true, isWithSpecial = true, length = 16
        )
    )
}

fun generatePassword(
    isWithUppercase: Boolean, isWithNumbers: Boolean, isWithSpecial: Boolean, length: Int
): String {
    val finalLength = when {
        length < 8 -> 8
        length > 16 -> 16
        else -> length
    }
    val characters = (97..123).toMutableList()

    if (isWithUppercase) {
        characters += (65..91).toList()
    }
    if (isWithNumbers) {
        characters += (48..58).toList()
    }
    if (isWithSpecial) {
        characters += (33..48).toList() + (58..65).toList() + (91..97).toList()
    }

    var result = ""
    while (result.length < finalLength) {
        result += Char(characters.random())
    }

    return result
}