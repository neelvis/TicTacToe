fun main() {
    var sequenceLenght = 0
    var user_input = readLine()!!.toInt()

    while(user_input > 0) {
        sequenceLenght++
        user_input = readLine()!!.toInt()
    }
    print(sequenceLenght)
}