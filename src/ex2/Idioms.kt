package ex2

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class Idioms {
    constructor() {
        "test space to camel case".spaceToCamelCase()
        testIfNotNullShorthand()
        textIfNotNull()
        transform("Red")
        transform("Blue")
        transform("Green")
        try {
            transform("Orange")
        } catch (e: IllegalArgumentException) {
            println("try catch: e = ${e}")
        }
        transform2("Red")
        println("testReturnIf(1) = ${testReturnIf(1)}")
        val intArray = arrayOfMinusOnes(5)
        for (a in intArray) {
            println("a = ${a}")
        }
        testReadFile()
        testLambdas()
    }

    fun String.spaceToCamelCase() {
        println("this is spaceToCamelCase()")
    }

    //singleton
    object Resource {
        val name = "Name"
    }

    fun testIfNotNullShorthand() {
        val files = File("Test").listFiles()
        println(files?.size)
        println(files?.size ?: "empty")
    }

    fun textIfNotNull() {
        val value = mapOf("email" to 2)
        value?.let { println("execute this block if not null") }
        val email = value["email"] ?: throw IllegalStateException("Email is missing!")
    }

    fun transform(color: String): Int {
        return when (color) {
            "Red" -> {
                println("color = ${color}")
                0
            }
            "Green" -> {
                println("color = ${color}")
                1
            }
            "Blue" -> {
                println("color = ${color}")
                2
            }
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    fun transform2(color: String): Int = when (color) {
        "Red" -> {
            println("color = ${color}")
            0
        }
        "Green" -> {
            println("color = ${color}")
            1
        }
        "Blue" -> {
            println("color = ${color}")
            2
        }
        else -> throw IllegalArgumentException("Invalid color param value")
    }

    fun testReturnIf(param: Int): String {
        return if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
    }

    fun arrayOfMinusOnes(size: Int): IntArray {
        return kotlin.IntArray(size).apply { fill(-1) }
    }

    fun testReadFile() {
        try {
            val stream = Files.newInputStream(Paths.get("/some/file.txt"))
            stream.buffered().reader().use { reader -> println("reader.readText = ${reader.readText()}") }
        } catch (e: Exception) {

        }
    }

    //在 Lambdas 表达式中，大括号与表达式间要有空格，箭头与参数和函数体间要有空格。
    // lambda表达应尽可能不要写在圆括号中
    fun testLambdas() {
        val list = listOf(12, 23, 34, 45, 56)
        list.forEach { println("it = ${it}") }
        val list2 = list.filter { it > 20 }.map { element -> element + 1 }
                .forEach { println("it2 = ${it}") }

    }
}

fun main(args: Array<String>) {
    val idioms = Idioms()
    with(idioms) {
        transform("Red")
        transform("Blue")
    }
}