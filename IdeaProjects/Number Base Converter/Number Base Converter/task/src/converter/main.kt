package converter

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.*

fun main() {
    do {
        when (val input1 = menu("Enter two numbers in format: {source base} {target base} (To quit type /exit)")) {
            "/exit" -> break
            else -> {
                val (sBase, tBase) = input1.split(' ').map { it.toInt() }
                do {
                    when (val input2 =
                        menu("Enter number in base $sBase to convert to base $tBase (To go back type /back)")) {
                        "/back" -> break
                        else -> startConversion(sBase, tBase, input2)
                    }
                } while (true)
            }
        }
    } while (true)
}

fun menu(q: String): String {
    println(q)
    return readLine()!!
}

fun startConversion(sBase: Int, tBase: Int, number: String) {
    var result = number
    if (sBase != 10) {
        result = convertToDecimal(sBase, number)
    }
    result = convertFromDecimal(tBase, result)
    println("Conversion result: $result\n")
}

fun convertToDecimal(sBase_: Int, number_: String): String {
    var result = BigDecimal.ZERO
    val numberMap = CharRange('0', '9') + CharRange('a', 'z')
    lateinit var number: List<String>
    var intPart = ""
    var fractPart = "-"

    try {
        number = number_.split('.')
        intPart = number[0]
        fractPart = number[1]
    }
    catch (e: IndexOutOfBoundsException) {
        intPart = number_
    }

    for (i in intPart.indices) {
        result += BigDecimal(
            (numberMap.indexOf(intPart[i]) * sBase_.toDouble().pow(intPart.length - i - 1)).toLong()
        )
    }
    if (fractPart == "-") return result.toString()

    for (i in fractPart.indices) {
        result += BigDecimal(numberMap.indexOf(fractPart[i]).toDouble() / (sBase_.toDouble().pow(i + 1)))
    }
    if (result.remainder(BigDecimal.ONE) == BigDecimal.ZERO) result = result.setScale(5, RoundingMode.UNNECESSARY)
    else result = result.setScale(6, RoundingMode.DOWN)
    return result.toString()
}

fun convertFromDecimal(tBase_: Int, number_: String): String {
    var result = ""
    lateinit var number: List<String>
    var intPart = BigDecimal.ZERO
    var fractPart = BigDecimal(-1)

    try {
        number = number_.split('.')
        intPart = number[0].toBigDecimal()
        fractPart = number[1].toBigDecimal().setScale(number[1].length, RoundingMode.UNNECESSARY)/BigDecimal.TEN.pow(number[1].length)
    }
    catch (e: IndexOutOfBoundsException) {
        intPart = number_.toBigDecimal()
    }

    val tBase = tBase_.toBigDecimal().setScale(2, RoundingMode.UNNECESSARY)
    val numberMap = CharRange('0', '9') + CharRange('a', 'z')
    if (intPart == BigDecimal.ZERO) result = "0"
    while (intPart > BigDecimal.ZERO) {
        result += numberMap[intPart.remainder(tBase).toInt()]
        intPart = (intPart.setScale(2, RoundingMode.FLOOR) / tBase).setScale(0, RoundingMode.FLOOR)
    }
    result = result.reversed()

    if (fractPart > BigDecimal(-1)) {
        result += '.'
        repeat (5) {
            val temp = fractPart * tBase
            val i = temp.setScale(0, RoundingMode.DOWN)
            val j = temp - i
            result += numberMap[i.toInt()]
            fractPart = j
        }
    }
    return result
}