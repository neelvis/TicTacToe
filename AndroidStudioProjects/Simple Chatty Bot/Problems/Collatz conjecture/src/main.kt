fun main() {
    var number = readLine()!!.toInt()
    print("$number ")

    while (number > 1) {
        if (number % 2 == 0) {
            number /= 2
            print("$number ")
        } else {
            number *= 3
            number += 1
            print("$number ")
        }
    }
}