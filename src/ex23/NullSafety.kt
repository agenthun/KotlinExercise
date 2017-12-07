package ex23


class NullSafety {
    constructor() {
        var a: String? = "a"
        a = null

        val l = if (a != null) a.length else -1
        if (a != null && a.length > 0) {
            print("String of length ${a.length}")
        } else {
            print("Empty string")
        }

        //safe call
        a?.length

        val listWithNulls: List<String?> = listOf("A", null)
        for (item in listWithNulls) {
            item?.let { print(it) }
        }

        val m: Int = if (a != null) a.length else -1
        //?:
        val n = a?.length ?: -1

        //!! return non-null value of a or throw an NPE if a is null
        val o = a!!.length

        //safe cast
        val aInt: Int? = a as? Int

        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
    }
}