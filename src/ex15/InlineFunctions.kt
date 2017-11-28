package ex15

import java.util.concurrent.locks.Lock
import javax.swing.tree.TreeNode

class InlineFunctions {
    //内联可能会引起生成代码增长，但我们可以合理的解决它(不要内联太大的函数)
    inline fun <T> lock(lock: Lock, body: () -> T): T? {
        return null
    }

    //只需要在内联函数中内联部分Lambda表达式，可以使用@noinline 注解来标记不需要内联的参数：
    inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {

    }

    fun <T> TreeNode.findParentOfType(clazz: Class<T>): T? {
        var p = parent
        while (p != null && !clazz.isInstance(p)) {
            p = p?.parent
        }
        return p as T
    }

    inline fun <reified T> TreeNode.findParentOfType(): T? {
        var p = parent
        while (p != null && p !is T) {
            p = p?.parent
        }
        return p as T
    }
}