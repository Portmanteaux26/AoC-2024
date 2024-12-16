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
        val reportAsList = report.split(" ")
        val reportInts = mutableListOf<Int>()
        for (string in reportAsList) {
            reportInts.add(string.toInt())
        }
        if (isSafe(reportInts)) {
            safeCount++
        }
    }

    return safeCount
}

private fun isSafe(report: MutableList<Int>): Boolean {

    var isIncreasing = false
    if (report[1] - report[0] >= 0) {
        isIncreasing = true
    }

    for (i in 1..<report.size) {
        val diff = report[i] - report[i-1]
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