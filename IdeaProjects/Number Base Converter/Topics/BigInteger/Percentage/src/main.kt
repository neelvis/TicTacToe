import java.math.BigInteger

fun main() {
    // write your code here
    val (a, b) = Array(2) { java.math.BigInteger(readLine()!!) }
    val sum = a + b

    val aPart = java.math.BigInteger.valueOf(100).multiply(a).divide(sum)
    val bPart = java.math.BigInteger.valueOf(100).multiply(b).divide(sum)

    print("${aPart.toInt()}% ${bPart.toInt()}%")
}
