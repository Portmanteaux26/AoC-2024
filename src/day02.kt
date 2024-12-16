import java.io.File
import kotlin.math.abs


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
        if (isSafe(report)) {
            safeCount++
        }
    }

    return safeCount
}

private fun isSafe(report: String): Boolean {

    val reportAsList = report.split(" ")
    val reportInts = mutableListOf<Int>()
    for (string in reportAsList) {
        reportInts.add(string.toInt())
    }

    var isIncreasing = false
    if (reportInts[1] - reportInts[0] >= 0) {
        isIncreasing = true
    }

    for (i in 1..<reportAsList.size) {
        val diff = reportInts[i] - reportInts[i-1]
        if (abs(diff) > 3 || diff == 0) {
            return false
        }
        if (isIncreasing && diff < 0) {
            return false
        }
        if (! isIncreasing && diff > 0) {
            return false
        }
    }

    return true
}