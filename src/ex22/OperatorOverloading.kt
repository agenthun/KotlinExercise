package ex22

class OperatorOverloading {
    data class Point(val x: Int, val y: Int)

    operator fun Point.unaryMinus() = Point(-x, -y)

    constructor() {
        val point = Point(10, 20)
        println("point = ${point}, -point = ${-point}")

        val a = 1
        val b = 2
        a.plus(b)
        a.minus(b)
        a.times(b)
        a.div(b)
        a.rem(b)
        a.mod(b)
        a.rangeTo(b)
        a.compareTo(b) > 0
    }
}

fun main(args: Array<String>) {
    val o = OperatorOverloading()
}
