package ex20

class TypeChecksAndCasts {
    constructor() {
        val obj = "113"
        if (obj is String) {
            println("obj.length = ${obj.length}")
        }
        if (obj !is String) {
            println("Not a String")
        } else {
            println("obj.length = ${obj.length}")
        }
    }

    fun demo(x: Any) {
        if (x is String) {
            println("x.length = ${x.length}")
        }
        if (x !is String || x.length == 0) return
        if (x is String && x.length > 0) {
            println("x.length = ${x.length}")
        }
        when (x) {
            is Int -> print(x + 1)
            is String -> print(x.length + 1)
            is IntArray -> print(x.sum())
        }

        val z = "12"
        //Unsafe
        val y1: String = z as String //maybe null exception
        val y2: String? = z as String? //nullable

        //Safe
        val y3: String? = z as? String
    }
}

fun main(args: Array<String>) {
    val t = TypeChecksAndCasts()
    t.demo("12312")
    t.demo(1)
}