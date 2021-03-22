fun main() {
    val length = readLine()!!.toInt()
    var printed = 0
    var number = 1
    while (printed != length) {
        for (i in 1..number) {
            print("$number ")
            printed++
            if (printed == length) break
        }
        number++
    }
}