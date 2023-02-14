package de.katas.codingame.longestCoast

import java.util.*

/**
 * https://www.codingame.com/ide/puzzle/longest-coast
 */

data class ExplorationReport(val islandIndex: Int, val islandCoast: Int, val totalIslands: Int)

/**
 * Starting point for kata
 * 1 - read grid size
 * 2 - read grid line by line
 */
fun start() {
    val input = Scanner(System.`in`)
    val n = input.nextInt()
    if (input.hasNextLine()) {
        input.nextLine()
    }
    var grid: Array<Array<Char>> = Array(n) {
        input.nextLine().toCharArray().toTypedArray()
    }

    val coastLine = calcCoastLine(grid, n)

    println(coastLine)
}

/**
 * https://www.codingame.com/ide/puzzle/longest-coast
 */
fun calcCoastLine(grid: Array<Array<Char>>, size: Int) : String {
    var report = ExplorationReport(0, 0, 0)
    var exploredLand: Set<Pair<Int, Int>> = mutableSetOf()
    var nextJumpDistance : Int = 1
    for (i in 0 until size) {
        for (j in 0 until size step nextJumpDistance) {
            if (exploredLand.contains(Pair(i,j)) && grid[i][j] == '~') {
                nextJumpDistance = 1
            }
            else {
//                report = bfs(i, report)
//                nextJumpDistance = getCoastDistance(grid[i], j)
            }
            // Wenn kein Wasser -> BFS Insel(i, report): LastCoast > j
            // | - update report
            // j++
        }
    }
    return "3 6"
}