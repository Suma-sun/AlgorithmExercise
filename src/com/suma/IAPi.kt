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

}