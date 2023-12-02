fun main() {
    fun part1(input: List<String>): Int {
        return input.map {
            val onlyDigits = it.filter { it.isDigit() }
            val firstDigit = onlyDigits.first()
            val lastDigit = onlyDigits.last()
            (firstDigit.toString() + lastDigit.toString()).toInt()
        }.sum()
    }

    val map = mapOf(
        "one" to "1",
        "two" to "2",
        "three" to "3",
        "four" to "4",
        "five" to "5",
        "six" to "6",
        "seven" to "7",
        "eight" to "8",
        "nine" to "9",
    )

    fun part2(input: List<String>): Int {
        val mapped = input.map { line ->
            val digitsList = mutableListOf<Int>()
            line.forEachIndexed { index, c ->
                if (c.isDigit()) {
                    digitsList.add(c.toString().toInt())
                } else {
                    map.forEach { (stringDigit, digit) ->
                        if (index + stringDigit.length > line.length) return@forEach
                        if (line.substring(index, index + stringDigit.length) == stringDigit) {
                            digitsList.add(digit.toInt())
                        }
                    }
                }
            }
            digitsList
        }
        return part1(mapped.map { it.joinToString("") })
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    val testInput2 = readInput("Day01_test2")
    check(part1(testInput) == 142)
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
