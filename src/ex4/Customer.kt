package ex4

class Customer(name: String) {
    init {
        println("Customer initialized with value ${name}")
        val customerKey = name.toUpperCase();
        println("customerKey = ${customerKey}")
    }
}

fun main(args: Array<String>) {
    val customer = Customer("c1")
}