package com.suma.dp

import com.suma.IAPi


/**
 * 动态规划2
 * https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/rt1hg6/
 */
data class Dp2(val obstacleGrid: Array<IntArray>): IAPi {

    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。")
        sb.appendLine("机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。")
        sb.appendLine("现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？")
        sb.appendLine("网格中的障碍物和空位置分别用 1 和 0 来表示。")
        sb.appendLine("输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]")
        sb.appendLine("输出：2")
        sb.appendLine("解释：3x3 网格的正中间有一个障碍物。")
        sb.appendLine("从左上角到右下角一共有 2 条不同的路径：")
        sb.appendLine("1. 向右 -> 向右 -> 向下 -> 向下")
        sb.appendLine("2. 向下 -> 向下 -> 向右 -> 向右")
    }

    override fun run() {
        val start = System.currentTimeMillis()
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val dp = Array(m){ IntArray(n) {0}  }
        obstacleGrid.forEach {
            log("source= ${it.contentToString()}")
        }

        if (obstacleGrid[0][0] == 1) {
            //特殊场景起点障碍 [[1,0],[0,0]]
            val end = System.currentTimeMillis()
            println("result 0 耗时：${end-start}")
            return
        } else {
            dp[0][0] = 1
        }

        for (i in 0 until  m) {
            for (j in 0 until n) {
                log("obstacleGrid[$i][$j] = ${obstacleGrid[i][j]}")
                if (i == 0 && j == 0) {
                    continue
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0
                } else {
                    if (i >= 1 && j >= 1) {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1]
                    } else if (i > 0) {
                        dp[i][j] = dp[i-1][j]
                    } else {
                        //j > 0
                        dp[i][j] = dp[i][j-1]
                    }
                }
            }
        }

        val end = System.currentTimeMillis()
        println("result ${dp[m-1][n-1]} 耗时：${end-start}\n")
    }
}

fun main() {
    val source = arrayOf(
        intArrayOf(0,0,0),
        intArrayOf(0,1,0),
        intArrayOf(0,0,0)
    )
    Dp2(source).let {
        it.printDesc()
        it.run()
    }

    val source2 = arrayOf(
        intArrayOf(1,0),
        intArrayOf(0,0)
    )
    Dp2(source2).let {
        it.printDesc()
        it.run()
    }

    val source3 = arrayOf(
        intArrayOf(0,1,0),
        intArrayOf(1,0,0),
        intArrayOf(0,0,0)
    )
    Dp2(source3).let {
        it.printDesc()
        it.run()
    }
}