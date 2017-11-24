package ex11

class Objects {
    class DataProvider
    //单例模式
    object DataProviderManager {
        fun registerDataProvider(provider: DataProvider) {

        }

        val allDataProviders: Collection<DataProvider>
            get() = listOf()
    }

    class MyClass {
        companion object Factory {
            fun create(): MyClass = MyClass()
        }
    }
}

fun main(args: Array<String>) {
    val objects = Objects()
    with(objects) {
        Objects.DataProviderManager.registerDataProvider(Objects.DataProvider())
        val instance = Objects.MyClass.create()
    }
}