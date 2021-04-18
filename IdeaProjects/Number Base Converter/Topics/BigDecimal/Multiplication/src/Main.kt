import java.math.BigDecimal

fun main() {
    // write your code here
    val numbers = Array(2) { readLine()!!.toBigDecimal() }

    print(numbers[0] * numbers[1])
}