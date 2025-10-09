// ===========================================================
// Nested vs Inner Class Comparison in Kotlin
// ===========================================================

class Outer(val outerName: String) {

    // Nested class: static-like, no reference to outer class
    class Nested(val nestedName: String) {
        fun info() {
            println("Nested class: $nestedName (cannot access Outer properties)")
        }
    }

    // Inner class: keeps reference to outer class
    inner class Inner(val innerName: String) {
        fun info() {
            println("Inner class: $innerName, Outer: $outerName (can access Outer properties)")
        }
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    println("=== Using Nested Class ===")
    val nestedObj = Outer.Nested("Nested1")
    nestedObj.info()
    // ❌ Cannot access outerName
    // println(nestedObj.outerName) // Error

    println("\n=== Using Inner Class ===")
    val outerObj = Outer("Outer1")
    val innerObj = outerObj.Inner("Inner1")
    innerObj.info()
    println("Directly accessing outer property from Inner: ${innerObj.innerName} inside ${outerObj.outerName}")

    println("\n=== Summary Table in Code ===")
    println("""
        Nested Class:
            - No reference to outer instance
            - Lightweight, like static
            - Use when outer context NOT needed

        Inner Class:
            - Keeps reference to outer instance
            - Can access outer properties directly
            - Use when outer context IS needed
    """.trimIndent())
}
