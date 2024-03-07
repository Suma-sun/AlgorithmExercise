package com.suma.hash

import com.suma.IAPi
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

data class Hash2(val data:Array<String>):IAPi {
    override fun printDesc() {
        val sb = StringBuilder()
        sb.appendLine("49.字母异位词")
        sb.appendLine("给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。")
        sb.appendLine("字母异位词 是由重新排列源单词的所有字母得到的一个新单词。")
        sb.appendLine("输入: strs = [\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"]")
        sb.appendLine("输出(List<List<String>>): [[\"bat\"],[\"nat\",\"tan\"],[\"ate\",\"eat\",\"tea\"]]")
        print(sb)
    }

    override fun run() {
        val start = System.currentTimeMillis()
        log("source=> ${data.contentToString()}")
        if (data.isEmpty()) {
            val end = System.currentTimeMillis()
            println("result [] 耗时：${end-start}\n")
            return
        }
        val map = HashMap<String,ArrayList<String>>()
        data.forEach {
            val array =  it.toCharArray()
            Arrays.sort(array)
            val item = String(array)

            if (map.containsKey(item)) {
                log("containsKey=>item")
                map.getOrDefault(item, ArrayList()).add(it)
            } else {
                log("put=>item")
                map[item] = ArrayList<String>().apply{
                    add(it)
                }
            }
        }

        val resultList = mutableListOf<List<String>>()
        map.values.forEach {
            resultList.add(it)
        }
        val sb = StringBuilder()
        sb.append("[")
        resultList.forEach {
            sb.append("[$it],")
        }
        sb.append("]")
        val end = System.currentTimeMillis()
        println("result $sb 耗时：${end-start}\n")
    }


}

fun main() {
    Hash2(
        arrayOf("eat","tea","tan","ate","nat","bat")
    ).run {
        printDesc()
        run()
    }
}