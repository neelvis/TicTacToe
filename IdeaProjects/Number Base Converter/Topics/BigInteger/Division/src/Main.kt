import java.math.BigInteger

fun main() {
    // write your code here
    val (a, b) = Array(2) { java.math.BigInteger(readLine()!!) }
    val (q, r) = a.divideAndRemainder(b)

    print("$a = $b*$q + $r")
}