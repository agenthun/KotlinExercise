package ex28

import java.util.*
import kotlin.collections.ArrayList

fun demo(source: List<Int>) {
    val list = ArrayList<Int>()
    for (item in source) {
        list.add(item)
    }
    for (i in 0..source.size - 1) {
        list[i] = source[i]
    }
}

fun calendarDemo() {
    val calendar = Calendar.getInstance()
    if (calendar.firstDayOfWeek == Calendar.SUNDAY) {
        calendar.firstDayOfWeek = Calendar.MONDAY
    }
    if (!calendar.isLenient) {
        calendar.isLenient = true
    }
}

fun nullSafety() {
    val list = ArrayList<String>()
    list.add("Item")
    val size = list.size
    val item = list[0]
    item.substring(1) //may item==null

    val nullable: String? = item
    val notNull: String = item //may fail at runtime
}

fun testJavaArrayExample() {
    val javaObj = JavaArrayExample()
    val array = intArrayOf(0, 1, 2, 3)
    javaObj.removeIndices(array)
    javaObj.removeIndicesVarArg(*array)
}

//In Kotlin, all exceptions are unchecked, meaning that the compiler does not force you to catch any of them.
//So, when you call a Java method that declares a checked exception, Kotlin does not force you to do anything
fun render(list: List<*>, to: Appendable) {
    for (item in list) {
        to.append(item.toString()) // Java would require us to catch IOException here
    }
}

fun testAccessStaticMembers() {
    if (Character.isLetter('a')) {
        println("is a")
    }
}

fun testThread() {
    Thread(Runnable { println("Thread.run, currentThread=${Thread.currentThread()}") }).start()
    println("currentThread=${Thread.currentThread()}")
}

fun main(args: Array<String>) {
    testThread()
}