fun main() {
    val count = readLine()!!.toInt()
    val sequence = Array<Int>(count) { readLine()!!.toInt() }
    var countInOrder = 1

    for (i in 1 until count) if (sequence[i] >= sequence[i-1]) countInOrder++

    print(if (count == countInOrder) "YES" else "NO")
}