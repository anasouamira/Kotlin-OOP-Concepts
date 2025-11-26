// A normal class with static-like members using companion object
class MathUtils {

    // Instance property (requires creating an object)
    var number: Int = 0

    // Companion object holds static-like members
    companion object {
        // Static-like property
        var PI = 3.14159

        // Static-like method
        fun square(x: Int): Int {
            return x * x
        }
    }
}

fun main() {
    // Accessing static-like members without creating an instance
    println(MathUtils.PI)            // Using property directly
    println(MathUtils.square(5))     // Using function directly

    // Creating an instance to access non-static properties
    val obj = MathUtils()
    obj.number = 10
    println(obj.number)
}
