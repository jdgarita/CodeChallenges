import java.security.SecureRandom

const val LETTERS: String = "abcdefghijklmnopqrstuvwxyz"
const val UPPERCASELETTERS: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
const val NUMBERS: String = "0123456789"
const val SPECIAL: String = "@#=+!£$%&?"

fun main() {
    println(
        generatePassword(
            isWithUppercase = false, isWithNumbers = true, isWithSpecial = true, length = 16
        )
    )
}

fun generatePassword(
    isWithUppercase: Boolean, isWithNumbers: Boolean, isWithSpecial: Boolean, length: Int
) = when (length) {
    in 8..16 -> {
        var result = ""
        var i = 0

        result += when {
            isWithUppercase -> UPPERCASELETTERS
            else -> LETTERS
        }
        if (isWithNumbers) {
            result += NUMBERS
        }
        if (isWithSpecial) {
            result += SPECIAL
        }

        val rnd = SecureRandom.getInstance("SHA1PRNG")
        val sb = StringBuilder(length)

        while (i < length) {
            val randomInt: Int = rnd.nextInt(result.length)
            sb.append(result[randomInt])
            i++
        }

        sb.toString()
    }

    else -> "invalid password length"
}