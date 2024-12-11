import java.io.File
import kotlin.math.abs


fun day01a() : Int {

    val (leftList, rightList, numIDs) = day01Input()

    leftList.sort()
    rightList.sort()

    var totalDist = 0
    for (i in 0..<numIDs) {
        val leftID = leftList[i].toInt()
        val rightID = rightList[i].toInt()
        val dist = abs(leftID - rightID)
        totalDist += dist
    }

    return totalDist
}

fun day01b() : Int {

    val (leftList, rightList, numIDs) = day01Input()

    val countMap = mutableMapOf<String, Int>()
    for (i in 0..<numIDs) {
        val leftID = leftList[i]
        for (rightID in rightList) {
            if (rightID == leftID) {
                countMap[leftID] = countMap.getOrDefault(rightID, 0) + 1
            }
        }
    }

    var simScore = 0
    for (id in countMap) {
        simScore += id.key.toInt() * id.value
    }

    return simScore
}

private fun day01Input(): Triple<MutableList<String>, MutableList<String>, Int> {

    val rawInput = File("input01.txt").readLines()

    val leftList = mutableListOf<String>()
    val rightList = mutableListOf<String>()
    for (line in rawInput) {
        val pair = line.split("   ")
        leftList.add(pair[0])
        rightList.add(pair[1])
    }
    val numIDs = leftList.size
    assert(numIDs == rightList.size && numIDs == rawInput.size)

    return Triple(leftList, rightList, numIDs)
}

fun main() {
    val totalDist = day01a()
    println(totalDist)
    val simScore =day01b()
    println(simScore)
}