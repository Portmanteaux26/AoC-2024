import java.io.File


fun day03Input(path: String): String {
    val rawInput = File(path).readText()
    return rawInput
}

fun filter(rawInput: String): MutableList<String> {

    val regex = Regex("""mul\(\d{1,3},\d{1,3}\)""")
    val matches = regex.findAll(rawInput)

    val instructions = mutableListOf<String>()
    for (match in matches) {
        instructions.add(match.value)
    }

    return instructions
}

fun totalResults(instructions: MutableList<String>): Int {

    var total = 0

    for (instruction in instructions) {
        val factorStrings = instruction.split(",")
        val factor1Str = factorStrings[0].filter { it.isDigit() }
        val factor2Str = factorStrings[1].filter { it.isDigit() }
        val factor1 = factor1Str.toInt()
        val factor2 = factor2Str.toInt()
        total += factor1 * factor2
    }

    return total
}