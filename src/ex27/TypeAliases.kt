package ex27

import java.io.File


typealias FileTable<K> = MutableMap<K, MutableList<File>>
typealias MyHandler = (Int, String, Any) -> Unit
typealias Predicate<T> = (T) -> Boolean

class A {
    inner class Inner
}

class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner


fun foo(p: Predicate<Int>) = p(42)

fun main(args: Array<String>) {
    val f: (Int) -> Boolean = { it > 0 }
    println("foo(f) = ${foo(f)}")

    val p: Predicate<Int> = { it > 0 }
    println("listOf(1, -2).filter(p) = ${listOf(1, -2).filter(p)}")
}