package ex9

class Generics {
    class Box<T>(t: T) {
        val value = t
    }

    val box: Box<Int> = Box<Int>(1)

    //只能读取的对象为生产者，只能写入的对象为消费者
    //声明处变型：通过注解类型参数 T 的来源，来确保它仅从 Source<T> 成员中返回（生产），并从不被消费。
    //为此，我们提供 out 修饰符
    //out只读
    abstract class Source<out T> {
        abstract fun nextT(): T
    }

    fun demoOut(strs: Source<String>) {
        val objexts: Source<Any> = strs
        println("objexts.nextT() = ${objexts.nextT()}")
    }

    //变型注释：in。它接受一个类型参数逆变：只可以被消费而不可以 被生产
    //in只写
    abstract class Comparable<in T> {
        abstract fun compareTo(other: T): Int
    }

    fun demoIn(x: Comparable<Number>) {
        x.compareTo(1.0)
        val y: Comparable<Double> = x
    }

    //泛型函数
//    fun <T> singletonList(item: T): List<T> {
//    }

//    fun <T> T.basicToString(): String {
//
//    }

//    val l = singletonList<Int>(1)

    fun <T : kotlin.Comparable<T>> sort(list: List<T>) {

    }

//    fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
//            where T : Comparable<T>,
//                  T : Cloneable {
//        return list.filter { it > threshold }.map { it.clone() }
//    }
}

fun main(args: Array<String>) {
    val generics = Generics()
    with(generics) {
        println("box.value=${box.value}")
        sort(listOf(1, 2, 3))
    }
}