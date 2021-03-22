package cinema

fun main() {
    // Read cinema hall size
    val sizeRequest = request2Numbers("Enter the number of rows", "Enter the number of seats in each row").split(' ')
    val rows = sizeRequest[0].toInt()
    val seats = sizeRequest[1].toInt()
    val cinemaSize = rows * seats
    var purchasedTickets = 0
    var percentPurchased = 0.0
    var currentIncome = 0
    val totalIncome = rows * seats * 8 + (rows / 2) * seats * 2

    var cinema = Array<CharArray>(rows) {
        CharArray(seats) {'S'}
    }

    do {
        print("""
            
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
        
    """.trimIndent())
        val input = readLine()!!.toInt()
        when (input) {
            1 -> visualizeCinemaHall(cinema)
            2 -> {
                cinema = buyTicket(cinema)
                visualizeCinemaHall(cinema)
                purchasedTickets++
                percentPurchased = purchasedTickets.toDouble() / cinemaSize * 100
                currentIncome = calculateIncome(cinema)
            }
            3 -> showStats(purchasedTickets, percentPurchased, currentIncome, totalIncome)
        }
    }
    while(input > 0)
}

fun showStats(purchasedTickets: Int, percentPurchased: Double, currentIncome: Int, totalIncome: Int) {
    print("""
        
        Number of purchased tickets: $purchasedTickets
        Percentage: ${String.format("%.2f", percentPurchased)}%
        Current income: $$currentIncome
        Total income: $$totalIncome
    """.trimIndent())
}

fun visualizeCinemaHall(cinema: Array<CharArray>) {
    print("""
         
        Cinema:
          
    """.trimIndent())
    for (i in cinema[0].indices) print("${i + 1} ")
    println("")
    for (i in cinema.indices) {
        print("${i + 1} ")
        for(j in cinema[i].indices) print("${cinema[i][j]} ")
        println("")
    }
}

fun request2Numbers(request1: String, request2: String): String {
    print("""             
            $request1:
            
        """.trimIndent())
    val answer1 = readLine()!!.toInt()
    print("""
            $request2:
            
        """.trimIndent())
    val answer2 = readLine()!!.toInt()

    return "$answer1 $answer2"
}

fun buyTicket(cinema: Array<CharArray>): Array<CharArray> {
    // Choose a seat
    var chosenRow = 0
    var chosenSeat = 0
    do {
        var again = true
        val requestedSeat = request2Numbers("Enter a row number", "Enter a seat number in that row").split(' ')
        chosenRow = requestedSeat[0].toInt()
        chosenSeat = requestedSeat[1].toInt()
        try {
            if (cinema[chosenRow - 1][chosenSeat - 1] == 'B') {
                println("That ticket has already been purchased!")
            } else {
                again = false
            }
        } catch (e: ArrayIndexOutOfBoundsException) {
            println("Wrong input!")
        }
    } while (again)

    println("row: $chosenRow/${cinema.size}, seat: $chosenSeat/${cinema[0].size}")
    // Show ticket cost and reserve a place
    cinema[chosenRow - 1][chosenSeat - 1] = 'B'
    print("Ticket price: $${calculateTicketCost(cinema.size, cinema[chosenRow - 1].size, chosenRow)}")

    return cinema
}

fun calculateTicketCost(rows: Int, seats: Int, chosenRow: Int): Int {
    if (rows * seats < 60 || chosenRow <= rows / 2) return 10
    return 8
}

fun calculateIncome(cinema: Array<CharArray>): Int {
    val rows: Int = cinema.size
    val seats: Int = cinema[0].size
    var placesFor10 = 0
    var placesFor8 = 0

    if (rows * seats < 60) {
        for (c in cinema)
            placesFor10 += c.count { it == 'B' }
    } else {
        val frontHalf = rows / 2
        val backHalf = rows - frontHalf
        for (i in 0 until frontHalf)
            placesFor10 += cinema[i].count { it == 'B' }
        for (i in frontHalf until cinema.size)
            placesFor8 += cinema[i].count { it == 'B' }
    }
    return placesFor10 * 10 + placesFor8 * 8
}