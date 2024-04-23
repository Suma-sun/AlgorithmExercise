package com.suma.pointer.sliding

import com.suma.IAPi

class SlidingWindow1(val content:String):IAPi {
    override fun printDesc() {
        println("https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked")
        println("3. 无重复字符的最长子串")
        println("给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。")
        println("示例 1:\n" +
                "\n" +
                "输入: s = \"abcabcbb\"\n" +
                "输出: 3 \n" +
                "解释: 因为无重复字符的最长子串是 \"abc\"，所以其长度为 3。\n" +
                "示例 2:\n" +
                "\n" +
                "输入: s = \"bbbbb\"\n" +
                "输出: 1\n" +
                "解释: 因为无重复字符的最长子串是 \"b\"，所以其长度为 1。\n" +
                "示例 3:\n" +
                "\n" +
                "输入: s = \"pwwkew\"\n" +
                "输出: 3\n" +
                "解释: 因为无重复字符的最长子串是 \"wke\"，所以其长度为 3。\n" +
                "     请注意，你的答案必须是 子串 的长度，\"pwke\" 是一个子序列，不是子串。\n")
        println("提示：\n" +
                "\n" +
                "0 <= s.length <= 5 * 104\n" +
                "s 由英文字母、数字、符号和空格组成")
    }

    override fun run() {
//        first()
        optimize()
    }

    private fun optimize() {
        val start = System.currentTimeMillis()
        if(content.isEmpty()) {
            print(start,0)
            return
        }
        val map = mutableMapOf<Char,Int>()
        var max = 0
        val array = content.toCharArray()
        var left = 0 //指向需要计算长度的开始位置
        //核心思路是，每次遇到重复字符，舍弃前面该字符位的内容，用新字符位置重新计算
        for (i in array.indices) {
            if (map.containsKey(array[i])) {
                //这里还没有更新max，使用原本的公式需要去掉当前字符位置，所以+1
                left = Math.max(left, (map[array[i]] ?:0) + 1)
            }
            map[array[i]] = i
            max = Math.max(max, i - left + 1)
        }
        print(start,max)
    }

    private fun first() {
        val start = System.currentTimeMillis()
        if(content.isEmpty()) {
            print(start,0)
            return
        }
        if(content.length == 1) {
            print(start,1)
            return
        }
        var set = HashSet<Char>()
        var max = 0
        val array = content.toCharArray()
        var left = 0
        var right = 1
        val lastIndex = array.lastIndex
        while(left < right && right <= lastIndex){
            set.add(array[left])
            while(right <= lastIndex) {
                if(set.contains(array[right])){
                    max = Math.max(max,right-left)//这里不用+1，因为right是++之后来判断的，这时候重复了就已经是长度了
                    //遇到重复，清空哈希表，修改指针位置
                    set.clear()
                    left++
                    right = left + 1
                    break
                } else if ((right == lastIndex)) {
                    max = Math.max(max,right-left + 1)
                    left++
                    right = left + 1
                    break
                }
                else {
                    set.add(array[right])
                    right++
                }
            }
            if (max >= array.size - left) {
                print(start,max)
                break
            }

        }
        print(start,max)
    }

    private fun print(start:Long,result:Int) {
        val sb = StringBuilder("input[$content]")
        sb.append("=>$result")
        printResult(sb.toString(),start)
    }
}

fun main() {
    SlidingWindow1("abcabcbb").apply {
        printDesc()
        run()
    }
    SlidingWindow1("bbbbb").apply {
        run()
    }
    SlidingWindow1("pwwkew").apply {
        run()
    }
    SlidingWindow1("au").apply {
        run()
    }
    SlidingWindow1("dvdf").apply {
        run()
    }
    SlidingWindow1("aab").apply {
        run()
    }
}