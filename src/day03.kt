import java.io.File


fun day03Input(path: String): String {
    val rawInput = File(path).readText()
    return rawInput
}

fun filter(rawInput: String): MutableList<String> {

    val regex = Regex("""mul\(\d{1,3},\d{1,3}\)""")
    val matches = regex.findAll(rawInput)

    val instructions = mutableListOf<String>()
    matches.forEach {
        matchResult -> instructions.add(matchResult.value)
    }

    return instructions
}