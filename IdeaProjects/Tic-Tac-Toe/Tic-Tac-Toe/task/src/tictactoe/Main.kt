package tictactoe

import java.lang.NumberFormatException

fun main() {
    // write your code here
    var gameField = "_________"
    var movesCount = 0
    val players = "XO"
    var gameState = "Game not finished"
    showField(gameField)
    do {
        var coordinates = ""
        do {
            print("Enter the coordinates: ")
            coordinates = readLine()!!
            val error = checkCoordinates(gameField, coordinates)
        } while (error)
        gameField = updateGameField(gameField, coordinates, players[movesCount % 2])
        movesCount++
        showField(gameField)
        gameState = analyseField(gameField)
    } while(gameState == "Game not finished")
    print(gameState)
}

fun updateGameField(gameField: String, coordinates: String, s: Char): String {
    val (x, y) = coordinates.split(' ').map { it.toInt() }
    val index = y - 1 + (x - 1) * 3
    var result = ""
    for (i in gameField.indices) {
        if (i == index) result += s
        else result += gameField[i]
    }
    return result
}

fun checkCoordinates(gameField: String, coordinates: String): Boolean {
    val (x, y) = try {
        coordinates.split(' ').map { it.toInt() }
    }
    catch(e: NumberFormatException) {
        println("You should enter numbers!")
        return true
    }
    if (x < 1 || x > 3 || y < 1 || y > 3) {
        println("Coordinates should be from 1 to 3!")
        return true
    }
    val index = y - 1 + (x - 1) * 3
    if (gameField[index] != '_') {
        println("This cell is occupied! Choose another one!")
        return true
    }
    return false
}
fun showField(gameField: String) {
    print("""
        ---------
        ${printFieldLine(gameField, 0)} 
        ${printFieldLine(gameField, 3)} 
        ${printFieldLine(gameField, 6)}         
        ---------
        
    """.trimIndent())
}

fun printFieldLine(gameField: String, lineNumber: Int): String {
    return("| ${gameField[lineNumber]} ${gameField[lineNumber + 1]} ${gameField[lineNumber + 2]} |")
}

fun analyseField(gameField: String): String {
    val xCount = gameField.count { it == 'X' }
    val oCount = gameField.count { it == 'O' }
    if (kotlin.math.abs(xCount - oCount) > 1)
        return "Impossible"

    val xWin = when (xCount) {
        in 3..5 -> checkWin('X', gameField)
        else -> false
    }
    val oWin = when (oCount) {
        in 3..5 -> checkWin('O', gameField)
        else -> false
    }

    if(xWin && oWin) return "Impossible"
    if(xWin) return "X wins"
    if(oWin) return "O wins"
    if(xCount + oCount == 9) return "Draw"
    return "Game not finished"
}

fun checkWin(c: Char, gameField: String): Boolean {
    if (gameField[0] == c && gameField[1] == c && gameField[2] == c ||
        gameField[3] == c && gameField[4] == c && gameField[5] == c ||
        gameField[6] == c && gameField[7] == c && gameField[8] == c ||
        gameField[0] == c && gameField[3] == c && gameField[6] == c ||
        gameField[1] == c && gameField[4] == c && gameField[7] == c ||
        gameField[2] == c && gameField[5] == c && gameField[8] == c ||
        gameField[0] == c && gameField[4] == c && gameField[8] == c ||
        gameField[2] == c && gameField[4] == c && gameField[6] == c)
            return true
    return false
}