package com.suma.dp

import com.suma.IAPi
import java.lang.Integer.min

data class Dp3Pro(val data: Array<IntArray>): IAPi {
    private val m = data.size
    private val n = data[0].size

    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，输出总和最低的路径（如果有多个答案，返回其中之一即可）？")
        sb.appendLine("说明：每次只能向下或者向右移动一步。")
        sb.appendLine("输入：grid = [[1,3,1],[1,5,1],[4,2,1]]")
        println(sb)
    }

    override fun run() {
        //优化是不创建dp[][]，直接用传入的二维数组，把计算后的积分直接填入
        val start = System.currentTimeMillis()
        val dp = Array(m){ IntArray(n){0} }
        val size = m * n
        val paths = IntArray(size){0}

        data.forEach {
            log("source=>${it.contentToString()}")
        }

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
                    paths[getIndex(i,j)] = getIndex(i-1,j)
                } else {
                    dp[i][j] = dp[i][j-1] + data[i][j]
                    paths[getIndex(i,j)] = getIndex(i,j-1)
                }
            }
        }

        val end = System.currentTimeMillis()
        println("result ${data[m-1][n-1]} 耗时：${end-start}\n")
    }


    private fun getIndex(i:Int, j:Int):Int {
        return i * n + j
    }
}

fun main() {
    val source = arrayOf(
        intArrayOf(1,3,1),
        intArrayOf(1,5,1),
        intArrayOf(4,2,1)
    )
    Dp3Pro(source).run {
        printDesc()
        run()
    }


}