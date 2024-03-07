package com.suma.dp

import com.suma.IAPi

/**
 * 动态规划1
 * https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/rtwu06/
 */
data class Dp1(val m: Int, val n: Int): IAPi {
    /*一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？

    输入：m = 3, n = 7
    输出：28*/

    override fun printDesc() {
        if (!isPrint())
            return
        val sb = StringBuilder()
        sb.appendLine("https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/rtwu06/")
        sb.appendLine("一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。\n" +
                "机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。\n" +
                "问总共有多少条不同的路径？")
        sb.appendLine("输入：m = 3, n = 7")
        sb.appendLine("输出：28")
        println(sb.toString())
    }

    /**
     *
     */
    override fun run() {
        val start = System.currentTimeMillis()
        println("m=$m n=$n ")
        val dp = Array(m+1){ IntArray(n+1){1} }

        for (i in 1..m) {
            for(j in 1..n) {
                log("i=$i j=$j dp[i-1][j]=${dp[i-1][j]} dp[i][j-1]=${dp[i][j-1]}")
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            }
        }
        val end = System.currentTimeMillis()
        println("result ${dp[m-1][n-1]} 耗时：${end-start}")
    }

}

fun main() {
    val dp = Dp1(3,7)
    dp.printDesc()
    dp.run()
//    println()
//    val m = Random.nextInt(1,100)
//    val n = Random.nextInt(1,100)
//    Dp1(m,n).run(m,n)
}