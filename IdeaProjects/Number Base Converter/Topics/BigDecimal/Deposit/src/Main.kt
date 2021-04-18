import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

fun main() {
    // write your code here
    val (amount, percent, years) = Array(3) { BigDecimal(readLine()!!) }

    val finalAmount = amount * (BigDecimal.ONE + percent.setScale(percent.scale() + 2, RoundingMode.UNNECESSARY)
            / BigDecimal(100)).pow(years.toInt())
    print("Amount of money in the account: ${finalAmount.setScale(2, RoundingMode.CEILING)}")
}