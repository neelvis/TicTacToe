import java.math.BigInteger

fun main() {
    val exabytes = readLine()!!.toInt()
    val bits = BigInteger("9223372036854775808") * exabytes.toBigInteger()

    print(bits)
}