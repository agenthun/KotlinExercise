package ex16

import kotlin.coroutines.experimental.RestrictsSuspension
import kotlin.coroutines.experimental.buildSequence

//协程: 1.1版本实验状态
class Coroutines {
    class Bar
    class Foo

    //suspend 修饰时表示可以被挂起
    //扩展函数（以及lambda）可以被标记为suspend
    suspend fun doSomething(foo: Foo): Bar {
        return Bar()
    }

    fun <T> async(block: suspend () -> T) {

    }

    fun testAsync() {
        async { doSomething(Foo()) }
    }

    interface Base {
        suspend fun foo()
    }

    class Derived : Base {
        suspend override fun foo() {

        }
    }

    //@RestrictsSuspension阻止用户添加新的挂起线程
    @RestrictsSuspension
    public abstract class SequenceBuilder<in T> {

    }

    val fibonacciSeq = buildSequence {
        var a = 0
        var b = 1
        yield(1)
        while (true) {
            yield(a + b)
            val tmp = a + b
            a = b
            b = tmp
        }
    }
}

fun main(args: Array<String>) {
    val c = Coroutines()
    with(c) {
        testAsync()
        fibonacciSeq.take(8).toList().forEach { println("it = ${it}") }
    }
}