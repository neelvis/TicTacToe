import java.util.*

fun main() {
    var maxValue = Int.MIN_VALUE
    var maxValueNumber = 0
    var currentValue = 0
    var currentValueNumber = 0

    val scanner = Scanner(System.`in`)
    while(scanner.hasNextInt()) {
        currentValue = scanner.nextInt()
        currentValueNumber++
        if (currentValue > maxValue) {
            maxValue = currentValue
            maxValueNumber = currentValueNumber
        }
    }

    print("$maxValue $maxValueNumber")
}