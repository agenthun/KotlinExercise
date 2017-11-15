package ex4

class ClassesAndInheritance {
}

//open 相当于可继承
open class Base {
    open fun v() {}
    fun nv() {}
}

class Derived() : Base() {
    override fun v() {
        super.v()
    }
}

open class AnotherDerived() : Base() {
    final override fun v() {
        super.v()
    }
}

class AnotherAnotherDerived() : AnotherDerived()


//open class View
//class MyView : View {
//    constructor(ctx: Context) : super(ctx)
//
//    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
//}

//接口
interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
    override val count: Int = 0
}

open class Foo2 {
    open fun f() {
        println("Foo.f()")
    }

    open val x: Int get() = 1
}

class SonFoo2 : Foo2() {
    override fun f() {
        super.f()
    }

    //修改x值
    override val x: Int
        get() = super.x + 1
}

class BarInner : Foo2() {
    override fun f() {
        super.f()
    }

    override val x: Int
        get() = 0

    inner class Baz {
        fun g() {
            super@BarInner.f() //BarInner.f()
            println("super@BarInner.x = ${super@BarInner.x}")
        }
    }
}

open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    } // interface members are 'open' by default

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    override fun f() {
        super<A>.f()// call to A.f()
        super<B>.f()// call to B.f()
    }
}

//抽象类
open class Base2 {
    open fun f() {}
}

abstract class AbsBase2 : Base2() {
    override abstract fun f()
}