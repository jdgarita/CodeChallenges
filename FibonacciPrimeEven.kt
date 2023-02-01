import kotlin.math.sqrt

fun main() {
    checkPrimeFibonacciEven(2)
    checkPrimeFibonacciEven(7)
    checkPrimeFibonacciEven(0)
    checkPrimeFibonacciEven(1)
    checkPrimeFibonacciEven(-2)
}

fun checkPrimeFibonacciEven(number: Int) {
    var result = "$number "
    var isFibonacci = false

    when {
        number > 1 -> for (i in 2..number) {
            if (number % i == 0) {
                result += "no es primo, "
                break
            } else {
                result += "es primo, "
                break
            }
        }
        else -> result += "no es primo, "
    }

    /**
     *   result += "es fibonacci " if number > 0 and (is_perfect_square(5 * number * number + 4) or is_perfect_square(
     *         5 * number * number - 4)) else "no es fibonacci "
     */
    result += when {
        number > 0 && (isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4)) -> "es fibonacci "
        else -> "no es fibonacci "
    }
    result += when {
        number % 2 == 0 -> "y es par"
        else -> "y es impar"
    }

    println(result)
}

private fun isPerfectSquare(number: Int): Boolean {
    val sqrt = sqrt(number.toDouble()).toInt()
    return sqrt * sqrt == number
}