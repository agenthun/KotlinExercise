package ex18

class Collections {
    constructor() {
        val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
        val readOnlyView: List<Int> = numbers
        println("numbers = ${numbers}")
        numbers.add(4)
        println("readOnlyView = ${readOnlyView}")

        val strings = hashSetOf("a", "b", "c", "c")
        assert(strings.size == 3)

        val items = listOf(1, 2, 3)
        items.first() == 1
        items.last() == 3
        items.filter { it % 2 == 0 }

        class Controller {
            private val _items = mutableListOf<String>()
            val items: List<String> get() = _items.toList()
        }

        val rwList = mutableListOf(1, 2, 3)
        rwList.requireNoNulls()
        if (rwList.none { it > 6 }) println("No items above 6")

        val item = rwList.firstOrNull()

        val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
        println("readWriteMap[\"foo\"] = ${readWriteMap["foo"]}")
        val snapshot: Map<String, Int> = HashMap(readWriteMap)
    }
}

fun main(args: Array<String>) {
    val c = Collections()
}