// ===========================================================
// Example: Inner Class in Kotlin
// ===========================================================

class Outer(val outerName: String) {

    // Inner class: keeps reference to Outer instance
    inner class Inner(val innerName: String) {
        fun greet() {
            println("Hello from Inner class: $innerName, Outer: $outerName")
        }

        fun showOuterReference() {
            println("Accessing Outer directly: $outerName")
        }
    }

    // Nested class for contrast
    class Nested(val nestedName: String) {
        fun greet() {
            println("Hello from Nested class: $nestedName (no Outer reference)")
        }
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Create Outer instance
    val outerObj = Outer("Outer1")

    // Create Inner instance using Outer object
    val innerObj = outerObj.Inner("Inner1")
    innerObj.greet()            // Can access Outer property
    innerObj.showOuterReference() // Access Outer directly

    // Nested class usage (no Outer reference)
    val nestedObj = Outer.Nested("Nested1")
    nestedObj.greet()
}
