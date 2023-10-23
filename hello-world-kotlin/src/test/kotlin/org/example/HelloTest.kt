package org.example

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HelloTest {

    @Test
    fun `sum elements of an array`() {
        val array: Array<Int> = arrayOf(1, 2, 3)

        val result = simpleArraySum(array)

        assertEquals(6, result)
    }


    @Test
    fun `should compare the triplets`() {
        val a: Array<Int> = arrayOf(1, 2, 3)
        val b: Array<Int> = arrayOf(3, 2, 1)

        val result = compareTriplets(a, b)

        assertEquals(1, result[0])
        assertEquals(1, result[1])
    }

    @Test
    fun `should sum a very big sum`() {
        val ar = arrayOf<Long>(1000000001, 1000000002, 1000000003, 1000000004, 1000000005)

        val result = aVeryBigSum(ar)

        assertEquals(5000000015, result)
    }

    @Test
    fun `should return a absolute diagonal difference`() {
        val arr = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(9, 8, 9)
        )

        val result = diagonalDifference(arr)

        assertEquals(2, result)
    }

    @Test
    fun `should print the ratios of positive negative and zero values`() {
        val arr = arrayOf(-4, 3, -9, 0, 4, 1)

        plusMinus(arr)
    }

    @Test
    fun `should print a staircase`() {
        staircase(6)
    }

    @Test
    fun `should calculate the mini-max sum`() {
        val arr = arrayOf(1, 2, 3, 4, 5)

        val result = miniMaxSum(arr)

        assertEquals(10, result[0])
        assertEquals(14, result[1])
    }

    @Test
    fun `should calculate the mini-max sum of unordered array`() {
        val arr = arrayOf(2, 4, 1, 5, 3)

        val result = miniMaxSum(arr)

        assertEquals(10, result[0])
        assertEquals(14, result[1])
    }

    @Test
    fun `should calculate the amount of high candles`() {
        val arr = arrayOf(3, 2, 1, 3)

        val result = birthdayCakeCandles(arr)

        assertEquals(2, result)
    }

    @Test
    fun `should return the time converted to military format`() {
        assertEquals("12:01:00", timeConversion("12:01:00PM"))
        assertEquals("00:01:00", timeConversion("12:01:00AM"))
        assertEquals("04:08:15", timeConversion("04:08:15AM"))
        assertEquals("19:05:45", timeConversion("07:05:45PM"))
    }

    @Test
    fun `should calculate the number of containers needed`() {
        val arr = arrayOf(1, 2, 3, 21, 7, 12, 14, 21)

        val result = toys(arr)

        assertEquals(4, result)
    }
}
