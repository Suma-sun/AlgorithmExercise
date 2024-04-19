package com.suma.pointer

import com.suma.IAPi

class Pointer1(val data:IntArray) :IAPi{

    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("283.移动零")
        sb.appendLine("给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。")
        sb.appendLine("请注意 ，必须在不复制数组的情况下原地对数组进行操作。")
        sb.appendLine("一：")
        sb.appendLine("输入: nums = [0,1,0,3,12]")
        sb.appendLine("输出: [1,3,12,0,0]")
        sb.appendLine("二：")
        sb.appendLine("输入: nums = [0]")
        sb.appendLine("输出: [0]")
        print(sb)
    }

    override fun run() {
        val start = startTime()
//        arrayFunc()
//        twoPointer()
        twoPointerFor()

        val sb = StringBuilder()
        sb.append(data.contentToString())
        printResult(sb.toString(),start)
    }

    /**
     * 双指针for解法
     */
    private fun twoPointerFor() {
        /*
         * index存储的未替换的0的位置，index与i索引的值相同时替换本身并+1，
         * 当出现0时出现分叉，index保持不动，待i位出现非0时替换
         */
        var index = 0
        var temp:Int
        for (i in data.indices) {
            if (data[i] != 0) {
                temp = data[index]
                data[index] = data[i]
                data[i] = temp
                index++
            }
        }
    }

    /**
     * 双指针解法,左指针指向要替换的数据位（非0），右指针为遍历用
     */
    private fun twoPointer() {
        val length = data.size
        var left = 0
        var right = 0
        while (right < length) {
            if (data[right] != 0) {
                val temp = data[left]
                data[left] = data[right]
                data[right] = temp
                left++
            }
            right++
        }
    }

    /**
     * 列表抽取法，性能较低的解法
     */
    private fun arrayFunc(){
        //需要额外的数组，且超过一轮的循环
        val list = mutableListOf<Int>()
        var curr:Int
        for (i in data.indices) {
            curr = data[i]
            if (curr != 0) {
                list.add(curr)
            }
        }
        if (list.size > 0) {
            var reverseIndex = list.lastIndex
            list.forEach{index->
                data[index] = data[reverseIndex]
                data[reverseIndex] = 0
                reverseIndex--
            }
        }
    }

}

fun main() {
    Pointer1(
        intArrayOf(0,1,0,3,12)
    ).run {
        printDesc()
        run()
    }
    Pointer1(
        intArrayOf(0)
    ).run {
        run()
    }
}