package ex8

class DataClasses {
    data class User(val name: String, val age: Int)

    data class User2(val name: String = "", val age: Int = 0)

    fun testCopy() {
        val jack = User("Jack", 1)
        println("jack = ${jack}")
        val olderJask = jack.copy(age = 2)
        println("olderJask = ${olderJask}")
    }
}

fun main(args: Array<String>) {
    val dataClasses = DataClasses()
    with(dataClasses) {
        testCopy()
        val jane = DataClasses.User("Jane", 35)
        val (name, age) = jane
        println("name = ${name}, age = ${age}")
    }
}