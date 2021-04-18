import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    // write your code here
    val numbers = Array(3) { BigDecimal(readLine()!!) }
    val avg = (numbers[0] + numbers[1] + numbers[2]) / BigDecimal(3)

    print(avg.setScale(0, RoundingMode.DOWN))
}