package ex7

class Extensions {
    fun MutableList<Int>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    fun MutableList<Int>.printAll() {
        this.forEach { kotlin.io.println(it) }
    }

    open class C {
        fun foo2() {
            println("c.foo2.member")
        }
    }

    fun C.foo2() {
        println("c.foo2().extension")
    }

    fun C.foo2(i: Int) {
        println("c.foo2(i).extension")
    }

    class D : C()

    fun C.foo() = "c"
    fun D.foo() = "d"

    fun printFoo(c: C) {
        println(c.foo())
    }

    fun Any?.toString(): String {
        if (this == null) return "null"
        return toString()
    }

    fun Any?.printIt() = if (this == null) print("is null") else println(this)

    val <T> List<T>.lastIndex: Int
        get() = size - 1

    open class E {
    }

    class F : E() {
    }

    open class G {
        open fun E.foo() {
            println("E.foo in G")
        }

        open fun F.foo() {
            println("F.foo in G")
        }

        fun caller(e: E) {
            e.foo()
        }
    }

    class G1 : G() {
        override fun E.foo() {
            println("E.foo in G1")
        }

        override fun F.foo() {
            println("F.foo in G1")
        }
    }
}

fun main(args: Array<String>) {
    val extensions = Extensions()
    with(extensions) {
        val l = mutableListOf(1, 2, 3)
        l.printAll()
        l.swap(0, 2)
        l.printAll()
        printFoo(Extensions.D()) //打印c,扩展是静态的

        val c = Extensions.C()
        c.foo2() //打印c.foo2.member, 同名同参数调用成员函数
        c.foo2(1) //打印c.foo2.extension, 同名不同参数可重载

        null.toString().printIt() //print null
        "Str".toString().printIt() //print Str

        listOf(1, 2, 3, 4, 5, 6).lastIndex.printIt() //5

        Extensions.G().caller(Extensions.E()) //E.foo in G
        Extensions.G1().caller(Extensions.E()) //E.foo in G1
        Extensions.G().caller(Extensions.F()) //E.foo in G 静态的
        Extensions.G1().caller(Extensions.F()) //E.foo in G1
    }
}