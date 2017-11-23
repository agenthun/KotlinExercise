package ex10

class EnumClasses {
    enum class Direction {
        NORTH, SOURTH, WEST, EAST
    }

    enum class Color(val rgb: Int) {
        RED(0xff0000),
        GREEN(0x0000ff),
        BLUE(0x0000ff)
    }

    enum class ProtocalState {
        WAITING {
            override fun signal() = TALKING
        },
        TALKING {
            override fun signal() = WAITING
        }; //注意分号
        //可以有对应的方法，以及复写基本方法。注意如果枚举定义了任何成员，你需要像在 java 中那样用分号 ; 把枚举常量定义和成员定义分开。

        abstract fun signal(): ProtocalState
    }
}

fun main(args: Array<String>) {
    val enumClasses = EnumClasses()
    with(enumClasses) {
        println("EnumClasses.Direction.NORTH = ${EnumClasses.Direction.NORTH}") //打印NORTH
        println("EnumClasses.Direction.NORTH.name = ${EnumClasses.Direction.NORTH.name}") //打印NORTH
        println("EnumClasses.Direction.NORTH.ordinal = ${EnumClasses.Direction.NORTH.ordinal}") //打印0
        println("EnumClasses.Color.RED = ${EnumClasses.Color.RED}") //打印RED
        println("EnumClasses.Color.RED.name = ${EnumClasses.Color.RED.name}") //打印RED
        println("EnumClasses.Color.RED.ordinal = ${EnumClasses.Color.RED.ordinal}") //打印0
    }
}