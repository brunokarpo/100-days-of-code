package org.example

import kotlin.math.abs

fun simpleArraySum(ar: Array<Int>): Int {
    return ar.sum()
}

fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    val result = arrayOf(0, 0)
    for (i in 0..2) {
        if (a[i] < b[i]) {
           result[1] += 1
        } else if (a[i] > b[i]) {
            result[0] += 1
        }
    }
    return result
}

fun aVeryBigSum(ar: Array<Long>): Long{
    return ar.sum()
}

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    val size = arr.size
    var primaryDiagonalSum = 0
    var secondaryDiagonalSum = 0

    for (i in 0 until size) {
        primaryDiagonalSum += arr[i][i]
        secondaryDiagonalSum += arr[i][size - 1 - i]
    }

    return abs(primaryDiagonalSum - secondaryDiagonalSum)
}

fun plusMinus(arr: Array<Int>) {
    var positiveNumbers = 0
    var negativeNumbers = 0
    var zeroNumbers = 0
    val arraySize = arr.size

    for (i in 0 until arraySize) {
        when {
            arr[i] > 0 -> positiveNumbers++
            arr[i] < 0 -> negativeNumbers++
            else -> zeroNumbers++
        }
    }

    println(String.format("%.6f", positiveNumbers.toFloat()/arraySize))
    println(String.format("%.6f", negativeNumbers.toFloat()/arraySize))
    println(String.format("%.6f", zeroNumbers.toFloat()/arraySize))
}

fun staircase(n: Int): Unit {
    for(i in 1 .. n) {
        val numberOfSpaces = n - i
        for (j in 0 until n) {
            if (j < numberOfSpaces) {
                print(" ")
            } else {
                print("#")
            }
        }
        if(i < n) println()
    }
}

fun miniMaxSum(arr: Array<Int>): Array<Long> {
    val mini = arr.sortedArray().map { it.toLong() }.slice(0 until  arr.size-1).sum()
    val max = arr.sortedArrayDescending().map { it.toLong() }.slice(0 until arr.size-1).sum()

    println("$mini $max")
    return arrayOf(mini, max)
}

fun birthdayCakeCandles(candles: Array<Int>): Int {
    val greaterAge = candles.maxOrNull()

    return candles.filter { it == greaterAge }.size
}

fun timeConversion(s: String): String {
    val isHourEqualTo12 = s.slice(0..1) == "12"
    val isPM = s.slice(s.length-2 until s.length) == "PM"

    if (isHourEqualTo12 and isPM) {
        return s.slice(0 until s.length-2)
    }
    if (isHourEqualTo12 and isPM.not()) {
        return "00" + s.slice(2 until s.length-2)
    }
    if (isPM.not()) {
        return s.slice(0 until s.length-2)
    }

    val hour = s.slice(0 until 2).toInt() + 12

    return hour.toString() + s.slice(2 until s.length-2)
}

fun toys(w: Array<Int>): Int {
    val sortedArray = w.sortedArray()

    var lowerHeight = sortedArray[0]
    var containers = 1

    sortedArray.forEach {
        if (it > lowerHeight + 4) {
            containers++
            lowerHeight = it
        }
    }

    return containers
}