package ex24


class Annotations {
    @Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.EXPRESSION)
    @Retention(AnnotationRetention.SOURCE)
    @Repeatable
    @MustBeDocumented
    annotation class Fancy

    @Fancy
    class Foo {
        @Fancy
        fun baz(@Fancy foo: Int): Int {
            return (@Fancy 1)
        }
    }

    annotation class Special(val why: String)
    @Special("examlpe")
    class Foo2 {}

    annotation class ReplaceWith(val expression: String)
    annotation class Deprecated(
            val message: String,
            val replaceWith: ReplaceWith = ReplaceWith(""))

    @Deprecated("This function is deprecated, use === instead", ReplaceWith("this === other"))
    class Foo3

    annotation class Suspendable

    val f = @Suspendable { }
}
