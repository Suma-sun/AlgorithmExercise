package com.suma.hash

import com.suma.IAPi
import java.util.*

class Hash3(val data:IntArray):IAPi {
    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("128.最长连续序列")
        sb.appendLine("给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。")
        sb.appendLine("请你设计并实现时间复杂度为 O(n) 的算法解决此问题。")
        sb.appendLine("示例 1：")
        sb.appendLine("输入：nums = [100,4,200,1,3,2]")
        sb.appendLine("输出：4")
        sb.appendLine("解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。")
        sb.appendLine("示例 2：")
        sb.appendLine("输入：nums = [0,3,7,2,5,8,4,6,0,1]")
        sb.appendLine("输出：9")
        sb.appendLine("提示：")
        sb.appendLine("0 <= nums.length <= 105")
        sb.appendLine("-10^9 <= nums[i] <= 10^9")
        println(sb)
    }

    override fun run() {
        val start = System.currentTimeMillis()
        log("source=> ${data.contentToString()}")
        Arrays.sort(data)

        val end = System.currentTimeMillis()
        println("result -- 耗时：${end-start}\n")
    }
}

fun main() {
    Hash3(
        intArrayOf(100,4,200,1,3,2)
    ).run{
        printDesc()
        run()
    }

    Hash3(
        intArrayOf(0,3,7,2,5,8,4,6,0,1)
    ).run()
}