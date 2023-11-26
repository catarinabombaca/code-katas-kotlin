package highestandlowest

fun run (input: String): String {
    val numbers = input.split(' ').map { it.toInt() }
    val lowestNumber = numbers.minOf { it }
    val highestNumber = numbers.maxOf { it }
    return "$highestNumber $lowestNumber"
}