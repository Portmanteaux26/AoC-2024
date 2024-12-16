import java.io.File


fun day03Input(path: String): String {
    val rawInput = File(path).readText()
    return rawInput
}

fun filter(rawInput: String): String {

    val reg = Regex("mul(.+,.+)")
    val matches = reg.findAll(rawInput)
    val instructions = matches.map{it.groupValues}.joinToString()

    return instructions
}