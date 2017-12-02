package ex19

class Ranges {
    constructor() {
        val i = 9
        if (i in 1..10) {
            println("i = ${i}")
        }

        for (i in 1..4) println("i in 1..4, i = ${i}")
        for (i in 4..1) println("i in 4..1, i = ${i}") //nothing
        for (i in 4 downTo 1) println("i in 4 downTo 1, i = ${i}")
        for (i in 1..4 step 2) println("i in 1..4 step 2, i = ${i}")
        for (i in 4 downTo 1 step 2) println("i in 4 downTo 1 step 2, i = ${i}")
        for (i in 1 until 10) { //i in [1, 10)
            println("i = ${i}")
        }

        println("(1..12 step 2).last == 11 , ${(1..12 step 2).last == 11}")
        println("(1..12 step 3).last == 10 , ${(1..12 step 3).last == 10}")
        println("(1..12 step 4).last == 9 , ${(1..12 step 4).last == 9}")
    }
}

fun main(args: Array<String>) {
    val r = Ranges()
}