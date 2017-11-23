package ex10

class NestedAndInnerClasses {
    class Outer {
        private val bar: Int = 1

        //嵌套类
        class Nested {
            fun foo() = 2
        }

        //内部类
        inner class Inner {
            fun foo() = bar
        }
    }
}

fun main(args: Array<String>) {
    val nestedAndInnerClasses = NestedAndInnerClasses()
    with(nestedAndInnerClasses) {
        val nestedFoo = NestedAndInnerClasses.Outer.Nested().foo()
        println("nestedFoo = ${nestedFoo}") //2
        val innerFoo = NestedAndInnerClasses.Outer().Inner().foo()
        println("innerFoo = ${innerFoo}") //1
    }
}