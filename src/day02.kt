import java.io.File


fun day02input(): MutableList<String> {

    val rawInput = File("input02.txt").readLines()

    val reportsList = mutableListOf<String>()
    for (line in rawInput) {
        reportsList.add(line)
    }

    return reportsList
}

fun safeReports(reports: MutableList<String>): Int {

    var safeCount = 0
    for (report in reports) {
        if (isSafe()) {
            safeCount++
        }
    }

    return safeCount
}

private fun isSafe(): Boolean {
    return true
}