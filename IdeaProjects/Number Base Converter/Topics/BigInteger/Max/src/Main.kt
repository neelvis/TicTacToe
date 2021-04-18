import java.math.BigInteger

fun main() {
    // write your code here
    val (a, b) = Array(2) { java.math.BigInteger(readLine()!!) }
    val max = (a + b + (a - b).abs()).divide(BigInteger.valueOf(2))

    print(max)
}