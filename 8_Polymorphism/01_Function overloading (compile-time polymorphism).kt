// ===========================================================
// Example: Function Overloading (Compile-time Polymorphism)
// ===========================================================

class Calculator {

    // Function 1: add two Ints
    fun add(a: Int, b: Int): Int {
        println("Adding two Ints")
        return a + b
    }

    // Function 2: add three Ints (different number of parameters)
    fun add(a: Int, b: Int, c: Int): Int {
        println("Adding three Ints")
        return a + b + c
    }

    // Function 3: add two Doubles (different parameter types)
    fun add(a: Double, b: Double): Double {
        println("Adding two Doubles")
        return a + b
    }

    // Function 4: add two Strings (different parameter types again)
    fun add(a: String, b: String): String {
        println("Concatenating two Strings")
        return a + b
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val calc = Calculator()

    // Kotlin decides which version of 'add' to call at COMPILE TIME
    println(calc.add(3, 5))         // Calls add(Int, Int)
    println(calc.add(1, 2, 3))      // Calls add(Int, Int, Int)
    println(calc.add(2.5, 4.3))     // Calls add(Double, Double)
    println(calc.add("Hello, ", "Kotlin")) // Calls add(String, String)
}
