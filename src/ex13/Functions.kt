package ex13

class Functions {
    fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {

    }

    fun foo(vararg strings: String) {}

    class Graph
    class Vertex

    fun dfs(graph: Graph) {
        fun dfs(curret: Vertex, visited: Set<Vertex>) {
        }
    }
}

fun main(args: Array<String>) {
    val f = Functions()
    with(f) {
        foo(1) { } //set bar=1
        foo { } //default value
        foo(baz = 2) { } //set baz=2

        foo(strings = "a")
        foo(strings = *arrayOf("a", "b", "c"))
    }
}