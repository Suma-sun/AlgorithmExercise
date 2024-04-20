package com.suma.pointer

import com.suma.IAPi
import java.util.*

class Pointer4(val nums:IntArray, val target:Int):IAPi {
    override fun printDesc() {
        println("https://leetcode.cn/problems/3sum-closest/description/")
        println("16. 最接近的三数之和")
        println("给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。\n" +
                "返回这三个数的和。\n" +
                "假定每组输入只存在恰好一个解。")
        println("示例 1：\n" +
                "\n" +
                "输入：nums = [-1,2,1,-4], target = 1\n" +
                "输出：2\n" +
                "解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。\n" +
                "示例 2：\n" +
                "\n" +
                "输入：nums = [0,0,0], target = 1\n" +
                "输出：0\n" +
                " \n" +
                "提示：\n" +
                "\n" +
                "3 <= nums.length <= 1000\n" +
                "-1000 <= nums[i] <= 1000\n" +
                "-104 <= target <= 104")
    }

    override fun run() {
        val start = startTime()
        val result = threeSumClosest(nums, target)

        val sb = StringBuilder(nums.contentToString())
        sb.append("-target[$target]")
        sb.append("=>[$result]")
        printResult(sb.toString(),start)
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        Arrays.sort(nums)
        var result = Int.MAX_VALUE

        var left:Int
        var right:Int
        var sum:Int
        for(i in nums.indices){
            if(i>0 && nums[i] == nums[i - 1]) {
                continue //过滤相同的数据
            }

            left = i + 1
            right = nums.lastIndex
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right]
                if(sum == target) {
                    return sum
                } else  {
                    if(Math.abs(target - result) > Math.abs(target - sum)) {
                        result = sum
                    }

                    if(target > sum) {
                        while(left< right && nums[left] == nums[left+1]) {
                            left++
                        }
                        left++
                    } else {
                        while(left<right && nums[right] == nums[right-1]) {
                            right--
                        }
                        right--
                    }
                }
            }
        }
        return result
    }
}

fun main() {
    Pointer4(intArrayOf(-1,2,1,-4),1).apply {
        printDesc()
        run()
    }
    Pointer4(intArrayOf(0,0,0),1).apply {
        run()
    }
    Pointer4(intArrayOf(4,0,5,-5,3,3,0,-4,-5),-2).apply {
        run()
    }

}