package ex14

import java.util.concurrent.locks.Lock

class Lambdas {
    //高阶函数,可以接受函数作为参数或者返回一个函数的函数
    fun <T> lock(lock: Lock, body: () -> T): T {
        lock.lock()
        try {
            return body()
        } finally {
            lock.unlock()
        }
    }

//    val result = lock(lock, {
//        sharedResource.operation()
//    })
//
//    lock(lock){
//        sharedResource.operation()
//    }

    fun <T, R> List<T>.map(transform: (T) -> R):
            List<R> {
        val result = arrayListOf<R>()
        for (item in this) {
            result.add(transform(item))
        }
        return result
    }

    val doubled = listOf(1, 2, 3, 4).map { it -> it * 2 }.sortedBy { it }

    val map = mapOf("1" to "A", "2" to "B", "3" to "C").forEach { _, value -> println("$value") } //"_" unused

    fun compare(a: String, b: String): Boolean = a.length < b.length

    fun <T> max(collection: Collection<T>, less: (T, T) -> Boolean): T? {
        var max: T? = null
        for (it in collection)
            if (max == null || less(max, it))
                max = it
        return max
    }

    var sum: ((Int, Int) -> Int)? = null
    val sum2 = { x: Int, y: Int -> x + y }
    val sum3: (Int, Int) -> Int = { x, y -> x + y }
    fun sum4(x: Int, y: Int): Int = x + y

    class HTML {
        fun body() {}
    }

    fun html(init: HTML.() -> Unit): HTML {
        val html = HTML()
        html.init()
        return html
    }
}

fun main(args: Array<String>) {
    val l = Lambdas()
    with(l) {
        map
        val max1 = max(arrayListOf("1", "12", "123", "1234"), { a, b -> a.length < b.length })
        println("max1 = ${max1}")
    }
}