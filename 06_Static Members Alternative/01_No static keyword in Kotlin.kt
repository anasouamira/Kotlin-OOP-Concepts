// =======================================================
// Example: No static keyword in Kotlin
// =======================================================

// In Java, we can write:
// class MathUtils {
//     public static int add(int a, int b) {
//         return a + b;
//     }
// }
//
// In Kotlin, there is NO 'static' keyword.
// Instead, we use 'companion object' to create static-like members.

class MathUtils {

    // The 'companion object' acts like a static area in Java
    companion object {
        // This function can be called without creating an object
        fun add(a: Int, b: Int): Int {
            return a + b
        }

        // A constant property that behaves like a static variable
        const val VERSION = "1.0"
    }
}


// =======================================================
// MAIN FUNCTION
// =======================================================
fun main() {

    // ✅ We can call the function directly using the class name
    println("Sum: ${MathUtils.add(10, 5)}")

    // ✅ Access the constant property directly
    println("Library Version: ${MathUtils.VERSION}")

    // ❌ No need to create an instance like this:
    // val obj = MathUtils()
    // obj.add(10, 5) // This is unnecessary
}
