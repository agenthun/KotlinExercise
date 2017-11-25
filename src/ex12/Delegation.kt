package ex12

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Delegation {
    //类代理
    interface Base {
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override fun print() {
            print(x)
        }
    }

    class Derived(b: Base) : Base by b

    fun testDelegation() {
        val b = BaseImpl(10)
        Derived(b).print() //打印10
    }

    class Example {
        val p: String by Delegate()
    }

    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name} in $thisRef.'")
        }
    }

    fun testDelegationProperties() {
        val e = Example()
        println(e.p)
    }

    //延迟,是一个接受 lamdba 并返回一个实现延迟属性的代理：第一次调用 get() 执行 lamdba 并传递 lazy() 并存储结果，以后每次调用 get() 时只是简单返回之前存储的值。
    val lazyValue: String by lazy {
        println("computed")
        "Hello"
    }

    //可观察属性
    class User {
        var name: String by Delegates.observable("<no name>") { prop, old, new ->
            println("$old->$new")
        }
    }
}

fun main(args: Array<String>) {
    val delegation = Delegation()
    with(delegation) {
        testDelegation()
        testDelegationProperties()

        println(lazyValue)//computed,Hello
        println(lazyValue)//Hello
        val user = Delegation.User()
        user.name = "first" //<no name>->first
        user.name = "second" //first->second
    }
}