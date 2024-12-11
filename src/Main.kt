import java.io.File;
import kotlin.math.abs


fun day01a() : Int {

    val (leftCol, rightCol, numIDs) = day01Input()

    leftCol.sort()
    rightCol.sort()

    var totalDist = 0
    for (i in 0..<numIDs) {
        val leftID = leftCol[i].toInt()
        val rightID = rightCol[i].toInt()
        val dist = abs(leftID - rightID)
        totalDist += dist
    }

    return totalDist
}

private fun day01Input(): Triple<MutableList<String>, MutableList<String>, Int> {

    val rawInput = File("input01.txt").readLines()

    val leftCol = mutableListOf<String>()
    val rightCol = mutableListOf<String>()
    for (line in rawInput) {
        val pair = line.split("   ")
        leftCol.add(pair[0])
        rightCol.add(pair[1])
    }
    val numIDs = leftCol.size
    assert(numIDs == rightCol.size && numIDs == rawInput.size)

    return Triple(leftCol, rightCol, numIDs)
}

fun main() {
    val totalDist = day01a()
    println(totalDist)
}