// ===========================================================
// Example: Nested Class in Kotlin
// ===========================================================

class Outer(val outerName: String) {

    // Nested class: behaves like static (no reference to Outer)
    class Nested(val nestedName: String) {
        fun greet() {
            println("Hello from Nested class: $nestedName")
        }
    }

    // Inner class (for contrast) keeps reference to Outer
    inner class Inner(val innerName: String) {
        fun greet() {
            println("Hello from Inner class: $innerName, Outer: $outerName")
        }
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Creating instance of Nested class
    val nestedObj = Outer.Nested("Nested1")
    nestedObj.greet()  // No access to Outer properties

    // Creating instance of Inner class
    val outerObj = Outer("Outer1")
    val innerObj = outerObj.Inner("Inner1")
    innerObj.greet()   // Can access Outer properties
}
