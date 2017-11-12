package ex1

class BasicSyntax {
    //var 可修改变量
    var mutableX = 5
    //val 只读变量
    val readOnlyX = 6

    constructor(a: Int, b: Int) {
        println("readOnlyX = ${readOnlyX}")
        val s1 = sum1(a, b)
        println("s1 = ${s1}")
        val s2: Int = sum2(a, b)
        println("s2 = ${s2}")
        sum3(a, b)
        sum4(a, b)
        println("mutableX = ${mutableX}")
        incrementX()
        mutableX = incrementX(mutableX)
        println("mutableX = ${mutableX}")
        val str123123 = "123123"
        println("replace123To321(®str123123) = ${replace123To321(str123123)}")

        val a1 = 2
        val a2 = 3
        println("a1 = ${a1}, a2 = ${a2}, max1=${maxOf1(a1, a2)}, max2=${maxOf2(a1, a2)}")
        println("parseInt(str123123) = ${parseInt(str123123)}")
        println("parseInt(str) = ${parseInt("str")}")
        forLoop1()
        forLoop2()
        while1()
        rangesX()
        collections()
    }

    fun sum1(a: Int, b: Int) = a + b

    fun sum2(a: Int, b: Int): Int {
        return a + b
    }

    fun sum3(a: Int, b: Int) {
        println("sum3(), $a + $b = ${a + b}")
    }

    fun sum4(a: Int, b: Int): Unit {
        println("sum4(), $a + $b = ${a + b}")
    }

    //x加1
    fun incrementX() {
        mutableX += 1
        println("mutableX = ${mutableX}")
    }

    //参数x加1
    fun incrementX(x: Int): Int {
        return x + 1
    }

    fun replace123To321(x: String) = x.replace("123", "321")

    fun maxOf1(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun maxOf2(a: Int, b: Int) = if (a > b) a else b

    fun parseInt(str: String): Int? {
        return getStringLength(str)
    }

    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun forLoop1() {
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println("forLoop1(), item = ${item}")
        }
    }

    fun forLoop2() {
        val items = listOf("apple", "banana", "kiwi")
        for (index in items.indices) {
            println("forLoop2(), item[$index] = ${items[index]}")
        }
    }

    fun while1() {
        val items = listOf("apple", "banana", "kiwi")
        var index = 0
        while (index < items.size) {
            println("while1(), items = ${items[index]}")
            when (items[index]) {
                "apple" -> {
                    println("when(), is apple!")
                }
                "banana" -> {
                    println("when(), is banana!")
                }
                "kiwi" -> {
                    println("when(), is kiwi!")
                }
            }
            index++
        }
    }

    fun rangesX() {
        val x = 10
        val y = 9
        if (x in 0..y + 1) {
            println("$x is in 0..${y + 1}")
        }

        for (z in 0..10) {
            println("z.for.in = ${z}")
        }

        for (z in 0..10 step 2) {
            println("z.for.in.step = ${z}")
        }

        for (z in 9 downTo 0 step 3) {
            println("z.for.in.downTo.step = ${z}")
        }
    }

    fun collections() {
        val items = listOf("apple", "banaba", "wiki")
        when {
            "apple" in items -> {
                println("found apple")
            }
        }
        items.filter { it.startsWith("a") }
                .sortedBy { it }
                .map { it.toUpperCase() }
                .forEach { println("it = ${it}") }
    }
}

fun main(args: Array<String>) {
    val basicSyntaxTest = BasicSyntax(3, 5)
    var s = basicSyntaxTest.sum1(3, 5)
    println("s1 = ${s}")
    s = basicSyntaxTest.incrementX(s)
    println("s2 = ${s}")

}