package ex3

class BasicTypes {
    fun testNumber() {
        val oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val hexBytes = 0xff_ec_de_5e
        val bytes = 0b11010010_01101001_10010100

        val a: Int = 100
        println("a == a, ${a == a}")
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println("boxedA = ${boxedA}")
        println("anotherBoxedA = ${anotherBoxedA}")
        println("boxedA == anotherBoxedA, ${boxedA == anotherBoxedA}")

        //wrong example
//        val intA: Int? = 1
//        val longA: Long? = intA //error
//        println("intA == longA ${intA == longA}")

        val b: Byte = 1
//        val i: Int = b //error
        val i: Int = b.toInt() //ok

        val l = 1L + 3 //Long
        println("l is Long = ${l is Long}")

        println("(1 shl 3) and 0x000ff000 = ${(1 shl 3) and 0x000ff00c}")

        println("-0.0 < 0.0 = ${if (-0.0 < 0.0) true else false}") //false
        println("-0.0 == 0.0 = ${if (-0.0 == 0.0) true else false}") //true
        println("-0.0 > 0.0 = ${if (-0.0 > 0.0) true else false}") //false
    }

    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9') {
            println("c is not in 0~9")
            return -1
        }
        return c.toInt() - '0'.toInt()
    }

    fun array() {
        val asc = Array(5, { i -> (i * i) }).forEach { println("asc.it = ${it}") } //0,1,4,9,16
        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]
    }

    fun string() {
        var text = """
            fun array() {

            }
            """
        println("text = ${text}")

        text = """
            |tell me
            |tell you
            |tell her
            |tell him
            """.trimMargin()
        println("text = ${text}")
    }
}

fun main(args: Array<String>) {
    val basicTypes = BasicTypes()
    with(basicTypes) {
        testNumber()
        println("decimalDigitValue('0') = ${decimalDigitValue('0')}")
        println("decimalDigitValue('c') = ${decimalDigitValue('c')}")
        array()
        string()
    }
}