package ex6

class Interfaces {
    interface MyInterface {
        fun bar()
        fun foo() {}
    }

    class Child : MyInterface {
        override fun bar() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    interface MyInterface2 {
        val prop: Int
        val propertyWithImplementation: String
            get() = "foo"

        fun foo() {
            print(prop)
        }
    }

    class Child2 : MyInterface2 {
        //        override val prop: Int
//            get() = 20
        override val prop: Int = 20
    }

    interface A {
        fun foo() {
            println("A.foo")
        }

        fun bar()
    }

    interface B {
        fun foo() {
            println("B.foo")
        }

        fun bar() {
            println("B.bar")
        }
    }

    class C : A {
        override fun bar() {
            println("C.bar")
        }
    }

    class D : A, B {
        override fun foo() {
            super<A>.foo()
            super<B>.foo()
        }

        //是A的实现,调用B的方法
        override fun bar() {
            super<B>.bar()
        }
    }
}

fun main(args: Array<String>) {
    val d = Interfaces.D()
    with(d) {
        foo()
        bar()
    }
}