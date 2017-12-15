package ex29;

public class JavaCode {
    void testKotlin() {
        new ex29.Foo();
        ex29.CallingKotlinFromJavaKt.bar();
        Key.COMPARATOR.compare(new Key(1), new Key(2));
        Singleton.provider = new Provider();

        int c = Obj.CONST;
        int d = CallingKotlinFromJavaKt.MAX;
        int v = C.VERSION;

        C.foo();
        C.Companion.foo();
        C.Companion.bar();
    }
}
