import java.io.File


fun day02input(): MutableList<String> {

    val rawInput = File("input02.txt").readLines()

    val reportsList = mutableListOf<String>()
    for (line in rawInput) {
        reportsList.add(line)
    }

    return reportsList
}