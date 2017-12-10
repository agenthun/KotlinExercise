package ex25

import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

class Reflection {
    fun isOdd(x: Int) = x % 2 != 0
    fun isOdd(s: String) = s == "brilling" || s == "slithy" || s == "tove"

    fun length(s: String) = s.length
    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        return { x -> f(g(x)) }
    }

    var x = 1

    constructor() {
        val numbers = listOf(1, 2, 3)

        val predicate: (String) -> Boolean = ::isOdd
        println("predicate = ${predicate}")
        val oddLength = compose(::isOdd, ::length)
        val strings = listOf("a", "ab", "abc")
        println(strings.filter(oddLength))

        println(::x.get()) //1
        println(::x.name) //x
        ::x.set(2)
        println(::x.get()) //2

        val prop = A::p
        println(prop.get(A(1))) //1
        println(A::p.javaGetter) //public final int ex25.Reflection$A.getP()
        println(A::p.javaField) //private final int ex25.Reflection$A.p

        val numberRegex = "\\d+".toRegex()
        println("numberRegex.matches(\"29\") = ${numberRegex.matches("29")}")

        val isNumber = numberRegex::matches
        println("isNumber(\"29\") = ${isNumber("29")}")
    }

    class A(val p: Int)
}

fun main(args: Array<String>) {
    val r = Reflection()
}