import java.math.BigInteger

fun main() {
    // write your code here
    val (a, b) = Array(2) { java.math.BigInteger(readLine()!!) }
    val lcm = a.multiply(b).divide(a.gcd(b))

    print(lcm)
}
