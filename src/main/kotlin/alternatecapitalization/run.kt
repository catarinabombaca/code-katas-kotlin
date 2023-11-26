package alternatecapitalization

fun run(string: String) : List<String> {
    val startWithUppercase = string.mapIndexed {i, char -> if (i % 2 == 0) char.uppercase() else char.lowercase() }.joinToString("")
    val startWithLowercase = string.mapIndexed {i, char -> if (i % 2 == 0) char.lowercase() else char.uppercase() }.joinToString("")

    return listOf(startWithUppercase, startWithLowercase)
}