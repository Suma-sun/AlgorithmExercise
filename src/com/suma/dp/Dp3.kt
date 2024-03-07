package com.suma.dp

import com.suma.IAPi
import java.lang.Integer.min

data class Dp3(val data: Array<IntArray>): IAPi {

    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。")
        sb.appendLine("说明：每次只能向下或者向右移动一步。")
        sb.appendLine("输入：grid = [[1,3,1],[1,5,1],[4,2,1]]")
        sb.appendLine("输出：7")
        sb.appendLine("解释：因为路径 1→3→1→1→1 的总和最小。")
        sb.appendLine("输入：grid = [[1,2,3],[4,5,6]]")
        sb.appendLine("输出：12")
        sb.appendLine("提示：")
        sb.appendLine("m == grid.length")
        sb.appendLine("n == grid[i].length")
        sb.appendLine("1 <= m, n <= 200")
        sb.appendLine("0 <= grid[i][j] <= 200")
        println(sb)
    }

    override fun run() {
        //优化是不创建dp[][]，直接用传入的二维数组，把计算后的积分直接填入
        val start = System.currentTimeMillis()
        val m = data.size
        val n = data[0].size
        val dp = Array(m){IntArray(n){0} }
        data.forEach {
            log("source=>${it.contentToString()}")
        }
        dp[0][0] = data[0][0]
        for (i in 0 until m) {
            for(j in 0 until n) {
                if (i==0 && j==0) {
                    continue
                }
                if (i>=1 && j>=1) {
                    //获取上一个最低的值
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + data[i][j]
                } else if (i>0) {
                    dp[i][j] = dp[i-1][j] + data[i][j]
                } else {
                    dp[i][j] = dp[i][j-1] + data[i][j]
                }
            }
        }

        val end = System.currentTimeMillis()
        println("result ${dp[m-1][n-1]} 耗时：${end-start}\n")
    }
}

fun main() {
    val source = arrayOf(
        intArrayOf(1,3,1),
        intArrayOf(1,5,1),
        intArrayOf(4,2,1)
    )
    Dp3(source).run {
        printDesc()
        run()
    }
    arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6)
    ).let { source->
        Dp3(source).run{
            run()
        }
    }

}