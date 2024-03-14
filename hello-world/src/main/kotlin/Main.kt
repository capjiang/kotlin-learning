@OptIn(ExperimentalStdlibApi::class)    // 实验性注解 1 ..< 10
fun main(args: Array<String>) {
    // 常量，变量（类型同Java）
    val v1:Int = Int.MAX_VALUE
    var v2:Int
    var v3:Long = 3L
    var v4 = 3.14f
    var v5 = 3.14
    var v2_10 = 0b1010
    var v16_10 = 0x10
    // 数组，列表，可变列表，集合，可变集合，映射表，可变映射表(可变才能调用add, remove)
    var arrayOf = arrayOf<Any>()
    var listOf = listOf<Int>()
    var mutableListOf = mutableListOf<Any>()
    setOf<Any>()
    mutableSetOf<Any>()
    mapOf<Any, Any>()
    mutableMapOf<Any, Any>()
    // 2元组，3元组
    var pair = Pair<Any, Any>(1, 2)
    var triple = Triple<Any, Any, Any>(1, 2, 3)
    // Any = Object, Nothing ≈ null
    var any1:Any
    var nothing1:Int ?= null
    // error: nothing.plus(1)
    nothing1?.plus(1)
    // !! 强制使用，可能会报错(空指针异常),但以后都不用再?.
//    nothing1!!.plus(1)
    // lateinit 随后初始化(未初始化异常),但以后都不用再?.
    lateinit var nothing2:String

    // 条件控制
    // if 可以有返回值
    var if1 = if (v1 == 0) {
        println("v1 = 0")
        0
    } else {
        println("v1 = ${v1}")
        v1
    }
    // when = swithch, 可以有返回值
    var whenVar:Any = 0
    var when1 = when (whenVar) {
        is String, in 1..10 -> {
            println("whenVar is String or in 1..10")
            1
        }

        else -> {
            println("whenVar")
            2
        }
    }

    // 区间 序列
    1..10
    // 1 until 10 （不建议使用） => 1..<10
    1..<10
    // 反过来
    10 downTo 1
    // 步数
    1..10 step 2
    // 可以浮点型, 字符型
    1f..10f
    'a'..'z'

    // 循环控制 (底层是迭代器iterator)
    val list = ('a'..'c').toList()
    for (c in list) {
        println(c)
    }
    for (c in list.withIndex()) {
        println("${c.index} to ${c.value}")
    }
    for ((index, value ) in list.withIndex()) {
        println("${index} to ${value}")
    }
    list.forEach {
        println(it)
    }
    list.forEach { v ->
        println(v)
    }
    list.forEachIndexed { index, c ->
        println("${index} to ${c}")
    }
    var while_i = 0
    while (while_i < 3) {
        while_i++
        println(while_i)
    }
    do {
        while_i--
        println(while_i)
    } while (while_i > 0)

    // break, continue, return
    break1@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) {
//                break@break1
                continue@break1
            }
            println("i = ${i}, j = ${j}")
        }
    }

    run {
        (1..3).forEach {
            if (it == 2) {
                return@run
            }
            println("run ${it}")
        }
    }


}
