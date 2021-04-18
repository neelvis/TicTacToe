import java.math.BigInteger

fun main() {
    val (a, b, c, d) = Array<BigInteger>(4) { BigInteger(readLine()!!) }
    print(-a * b + c - d)
}