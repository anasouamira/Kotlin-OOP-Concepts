// ===========================================================
// Example: The 'open' keyword in Kotlin
// ===========================================================

// 🔸 By default, every class in Kotlin is 'final'.
// That means you cannot inherit from it unless you mark it with 'open'.

// ❌ This class cannot be inherited from:
class ClosedClass {
    fun showMessage() {
        println("🚫 I cannot be inherited!")
    }
}

// ✅ This class can be inherited because it's marked as 'open'
open class OpenClass {

    // A normal function (not open) — cannot be overridden
    fun showInfo() {
        println("ℹ️ This is a normal function and cannot be overridden.")
    }

    // An open function — can be overridden in subclasses
    open fun greet() {
        println("👋 Hello from OpenClass!")
    }
}


// 🔹 Subclass that inherits from the open class
class SubClass : OpenClass() {

    // Overriding the open function
    override fun greet() {
        println("🙋‍♂️ Hello from SubClass, overriding OpenClass’s greet()!")
    }

    // New function specific to SubClass
    fun extra() {
        println("✨ This is a new method only in SubClass.")
    }
}


// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    println("=== Trying to inherit from ClosedClass ===")
    // val x = object : ClosedClass() {} // ❌ Error if uncommented (cannot inherit)

    println("----------------------------------------")

    println("=== Inheriting from OpenClass ===")
    val sub = SubClass()
    sub.greet()      // Calls overridden method
    sub.showInfo()   // Calls inherited non-open method
    sub.extra()      // Specific to SubClass
}
