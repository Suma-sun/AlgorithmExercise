package com.suma.hash

import com.suma.IAPi

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
        if(data.isEmpty()) {
            println("输出：数组为空")
            return
        }

        val set = mutableSetOf<Int>()
        for (item in data) {
            set.add(item)
        }
        var max = 0

        for (item in set) {
            //核心避免重复遍历，待数据到最小值才开始遍历
            if (!set.contains(item - 1)){
                var curr = item
                var length = 1
                while(set.contains(curr+1)) {
                    curr++
                    length++
                }
                //这行不能在循环里，比如[0]的数组
                max = Math.max(max,length)
            }

        }
        println("输出$max")

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