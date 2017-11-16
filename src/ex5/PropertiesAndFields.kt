package ex5

class PropertiesAndFields {
    class Address() {
        var name: String = "name"
        var street: String = "street"
        var city: String = "city"
        var state: String? = "state"
        var zip: String = "zip"
    }

    fun copyAddress(address: Address): Address {
        val result = Address()
        result.name = address.name
        result.street = address.street
        result.city = address.city
        result.state = address.state
        result.zip = address.zip
        return result
    }

    var stringRepresentation: String
        get() = this.toString()
        set(value) {}

    var counter = 0
        set(value) {
            if (value >= 0) field = value
        }

    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap()
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

//    const val SUBSYSTEM_DEPRECATED: String = "This subsystem"

    class TestSubject {
        fun method() {
        }
    }

    public class MyTest {
        //lateinit var 延迟初始化属性
        lateinit var subject: TestSubject

        fun setup() {
            subject = TestSubject()
        }

        fun test() {
            subject.method()
        }
    }
}