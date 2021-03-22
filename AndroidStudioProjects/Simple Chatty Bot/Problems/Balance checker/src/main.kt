import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    var money = scanner.nextInt()
    val purchases = mutableListOf<Int>()

    while (scanner.hasNextInt()) purchases.add(scanner.nextInt())

    var purchasesSum = purchases.sum()

    if (money >= purchasesSum) {
        println("Thank you for choosing us to manage your account! You have ${money - purchasesSum} money.")
    } else {
        for (p in purchases)
            if (money - p >= 0) {
                money -= p
                purchasesSum -= p
            }
        println("Error, insufficient funds for the purchase. You have $money, but you need $purchasesSum.")
        1
    }
}