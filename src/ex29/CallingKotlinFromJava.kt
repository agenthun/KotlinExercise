package ex29

class Foo

fun bar() {

}

class Key(val value: Int) {
    companion object {
        @JvmField
        val COMPARATOR: Comparator<Key> = compareBy<Key> { it.value }
    }
}

class Provider
object Singleton {
    lateinit var provider: Provider
}

object Obj {
    const val CONST = 1
}

class C {
    companion object {
        const val VERSION = 9
        @JvmStatic
        fun foo() {
        }

        fun bar() {}
    }
}

const val MAX = 239