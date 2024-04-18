package com.suma

interface IAPi {

    /**
     * 输出
     */
    fun printDesc()

    /**
     * 是否输出日志
     */
    fun isPrint() = true

    fun log(text:String) {
        if (isPrint()) {
            println(text)
        }
    }

    /**
     * 执行
     */
    fun run()

    /**
     * 输出结果
     * @param result 结果字符串
     * @param start 开始时间戳
     */
    fun printResult(result:String, start:Long) {
        val end = System.currentTimeMillis()
        println("result $result 耗时：${end-start}\n")
    }

    fun startTime():Long {
        return System.currentTimeMillis()
    }

}