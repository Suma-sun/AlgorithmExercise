package com.suma.pointer.sliding

import com.suma.IAPi
import java.util.*

class SlidingWindow2(val content:String, val target: String):IAPi {
    override fun printDesc() {
        println("https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked")
        println("438. 找到字符串中所有字母异位词")
        println("给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。")
        println("异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。")
        println("示例 1:\n" +
                "\n" +
                "输入: s = \"cbaebabacd\", p = \"abc\"\n" +
                "输出: [0,6]\n" +
                "解释:\n" +
                "起始索引等于 0 的子串是 \"cba\", 它是 \"abc\" 的异位词。\n" +
                "起始索引等于 6 的子串是 \"bac\", 它是 \"abc\" 的异位词。\n" +
                " 示例 2:\n" +
                "\n" +
                "输入: s = \"abab\", p = \"ab\"\n" +
                "输出: [0,1,2]\n" +
                "解释:\n" +
                "起始索引等于 0 的子串是 \"ab\", 它是 \"ab\" 的异位词。\n" +
                "起始索引等于 1 的子串是 \"ba\", 它是 \"ab\" 的异位词。\n" +
                "起始索引等于 2 的子串是 \"ab\", 它是 \"ab\" 的异位词。")
        println("提示:\n" +
                "\n" +
                "1 <= s.length, p.length <= 3 * 104\n" +
                "s 和 p 仅包含小写字母")
    }

    override fun run() {
        first()
//        optimize()
    }

    private fun optimize() {

    }

    private fun first() {
        val start = System.currentTimeMillis()
        val len = target.length
        if(content.length < len) {
            print(start,"[]")
        }

        val result = mutableListOf<Int>()
        val sortString = sortString(target)
        var left = 0
        var right = len
        var temp:String
        while(right <= content.length) {
            temp = content.substring(left,right)
            if(sortString == sortString(temp)) {
                result.add(left)
            }
            left++
            right++
        }

        print(start,result.toIntArray().contentToString())
    }

    private fun sortString(str:String):String {
        val array = str.toCharArray()
        Arrays.sort(array)
        return String(array)
    }

    private fun print(start:Long,result:String) {
        val sb = StringBuilder("input[$content][$target]")
        sb.append("=>$result")
        printResult(sb.toString(),start)
    }
}

fun main() {
    SlidingWindow2("cbaebabacd","abc").apply {
        printDesc()
        run()
    }
    SlidingWindow2("abab","ab").apply {
        run()
    }
}