fun main() {
    val input = day03Input("src/input03.txt")
    val instructions = filter(input)
    println(totalResults(instructions))
}