import java.math.BigDecimal
import java.math.RoundingMode

fun main() {             
    // write your code here
    val number = BigDecimal(readLine()!!)
    val newScale = readLine()!!.toInt()

    val scaledNumber = number.setScale(newScale, RoundingMode.HALF_DOWN)
    print(scaledNumber)
}