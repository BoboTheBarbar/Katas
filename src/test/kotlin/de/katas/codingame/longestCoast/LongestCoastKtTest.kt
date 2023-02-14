package de.katas.codingame.longestCoast

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LongestCoastKtTest {

    @Test
    fun calcCoastLine() {
        val n = 5
        val toTypedArray = """
            ~~~~#
            ~~~##
            ~~~~~
            ~##~~
            ~~~~~
        """.trimIndent().split("\n").toTypedArray()
        val grid = transformToGrid(toTypedArray)
        val result = calcCoastLine(grid, 5)
        Assertions.assertEquals(result, "3 6")
    }

    @Test
    fun calcCoastLineVerticalCoast() {
        val n = 3
        val toTypedArray = """
            ~~#
            ~~#
            ~~#
        """.trimIndent().split("\n").toTypedArray()
        val grid = transformToGrid(toTypedArray)
        val result = calcCoastLine(grid, n)
        Assertions.assertEquals(result, "3 6")
    }

    private fun transformToGrid(toTypedArray: Array<String>): Array<Array<Char>> {
        val grid = toTypedArray.map { it.toCharArray().toTypedArray() }.toTypedArray()
        return grid
    }
}