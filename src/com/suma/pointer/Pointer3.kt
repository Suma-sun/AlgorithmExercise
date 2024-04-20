package com.suma.pointer

import com.suma.IAPi
import java.util.*

class Pointer3(val data:IntArray):IAPi {
    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked")
        sb.appendLine("15. 三数之和")
        sb.appendLine("给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。")
        sb.appendLine("请你返回所有和为 0 且不重复的三元组。")
        sb.appendLine("注意：答案中不可以包含重复的三元组。")
        sb.appendLine("说明：你不能倾斜容器。")
        sb.appendLine("一：")
        sb.appendLine("输入: [-1,0,1,2,-1,-4]")
        sb.appendLine("输出: [[-1,-1,2],[-1,0,1]]")
        sb.appendLine("解释：")
        sb.appendLine("nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。")
        sb.appendLine("nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。")
        sb.appendLine("nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。")
        sb.appendLine("不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。")
        sb.appendLine("注意，输出的顺序和三元组的顺序并不重要。")
        sb.appendLine("二：")
        sb.appendLine("输入: [0,1,1]")
        sb.appendLine("输出: []")
        sb.appendLine("三：")
        sb.appendLine("输入: [0,0,0]")
        sb.appendLine("输出: [0,0,0]")
        print(sb)
    }

    override fun run() {
        val start = startTime()

        val result = twoPointer()

        val sb = StringBuilder(data.contentToString())
        sb.append("=>[")
        result.forEach {
            sb.append(it.contentToString()).append(",")
        }
        sb.append("]")
        printResult(sb.toString(),start)
    }

    private fun twoPointer():List<IntArray> {
        val result = mutableListOf<IntArray>()
        Arrays.sort(data)// O(NlogN)，先小到大排序一遍
        var left:Int
        var right:Int
        var sum:Int
        for (i in data.indices) {
            if(data[i] > 0) {
                //i是向右移动，右边>=当前，所以当遍历到这个场景，后面不会有匹配的组合了
                return result
            }
            if(i > 0 && data[i] == data[i-1]) {//组合去重
                //值相同是重复的组合，所以需要跳到不一样的值的位置
                continue
            }
            left = i + 1
            right = data.lastIndex
            while (left < right) {
                sum = data[i] + data[left] + data[right]
                if (sum == 0) {
                    result.add(intArrayOf(data[i],data[left],data[right]))
                    while(left < right && data[left] == data[left+1]) {//组合去重
                        left++
                    }
                    while (left < right && data[right] == data[right-1]) {//组合去重
                        right--
                    }
                    left++
                    right--
                } else if (sum > 0) {
                    //left右移是变大，所以这里要right左移来变小
                    right--
                } else {
                    left++
                }
            }
        }
        return result
    }
}

fun main() {
    Pointer3(intArrayOf(-1,0,1,2,-1,-4)).apply {
        printDesc()
        run()
    }
    Pointer3(intArrayOf(0,1,1)).apply {
        run()
    }
    Pointer3(intArrayOf(0,0,0)).apply {
        run()
    }
    Pointer3(intArrayOf(1,-1,-1,0)).apply {
        run()
    }
}