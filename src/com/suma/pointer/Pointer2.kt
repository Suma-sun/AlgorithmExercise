package com.suma.pointer

import com.suma.IAPi

class Pointer2(val data:IntArray) :IAPi{
    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked")
        sb.appendLine("11.盛最多水的容器")
        sb.appendLine("给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。")
        sb.appendLine("找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。")
        sb.appendLine("返回容器可以储存的最大水量。")
        sb.appendLine("说明：你不能倾斜容器。")
        sb.appendLine("一：")
        sb.appendLine("输入: [1,8,6,2,5,4,8,3,7]")
        sb.appendLine("输出: [49]")
        sb.appendLine("二：")
        sb.appendLine("输入: [1,1]")
        sb.appendLine("输出: [1]")
        print(sb)
    }

    override fun run() {
        val start = startTime()
//        val max = first()
        val max = twoPointer()

        val sb = StringBuilder()
        sb.append(data.contentToString())
        sb.append(">$max")
        printResult(sb.toString(),start)
    }

    private fun twoPointer():Int {
        //双指针，每轮对比两端的数，小的一边移动，记录过程中各自的最大值与索引来生成容器
        var max = 0
        var left = 0
        var right = data.lastIndex
        var leftHeight = 0
        var rightHeight = 0
        var targetLeft = left
        var targetRight = right
        while(right >= left) {
            if (rightHeight > leftHeight){
                //右边大，移动左边
                if (leftHeight < data[left]) {
                    leftHeight = data[left]
                    targetLeft = left
                    max = Math.max(max,Math.min(leftHeight,rightHeight) * (targetRight-left))
                }
                left++
            } else {
                if (rightHeight < data[right]) {
                    rightHeight = data[right]
                    targetRight = right
                    max = Math.max(max,Math.min(leftHeight,rightHeight) * (right-targetLeft))
                }
                right--
            }
        }

        return max
    }

    /**
     * 超出时间复杂度的解法
     */
    private fun first():Int {
        //两个循环，一个控制left，一个控制right，left 和 right之间形成容器，每轮筛选出该轮的最大容量
        var max = 0
        val lastIndex = data.lastIndex
        var right:Int
        var leftHeight:Int
        var rightHeight:Int
        var minHeight:Int
        for (left in 0..lastIndex) {
            right = data.lastIndex
            leftHeight = data[left]
            while (right > left) {
                rightHeight = data[right]
                minHeight = Math.min(leftHeight,rightHeight)
                max = Math.max(max,minHeight * (right - left))
                right--
            }
        }
        return max
    }
}

fun main() {
    Pointer2(intArrayOf(1,8,6,2,5,4,8,3,7)).apply {
        printDesc()
        run()
    }
    Pointer2(intArrayOf(1,1)).apply {
        run()
    }
}