package ex17

class DestructuringDeclarations {
    //    val (name, age) = person
//    val name = person.component1()
//    val age = person.component2()
    constructor() {
        for ((key, value) in mapOf("k1" to "v1", "k2" to "v2")) {
            println("key = ${key}, value = ${value}")
        }

        for ((_, value) in mapOf("k1" to "v1", "k2" to "v2")) {
            println("value = ${value}")
        }

        mapOf("k1" to "v1", "k2" to "v2").mapValues { (_, value) -> println("value = ${value}") }
        mapOf("k1" to "v1", "k2" to "v2").mapValues { (_, value): Map.Entry<String, String> -> println("value = ${value}") }
        mapOf("k1" to "v1", "k2" to "v2").mapValues { (_, value: String) -> println("value = ${value}") }
    }
}

fun main(args: Array<String>) {
    val d = DestructuringDeclarations()
}