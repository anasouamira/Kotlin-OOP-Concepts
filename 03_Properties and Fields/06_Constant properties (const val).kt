// ======================================================================================
// Constant properties in Kotlin using `const val`
// ======================================================================================
// const val is used to declare compile-time constants.
// These values are assigned during compilation and cannot change at runtime.
// Rules:
// 1. Must be placed at top-level, inside an object, or inside a companion object.
// 2. Can only hold primitive types or String.
// 3. CANNOT be used inside regular classes directly without companion/object.
// ======================================================================================

// Top-level constant (outside any class)
const val APP_VERSION = "1.0.0"   // accessible anywhere

class Car(val model: String, val year: Int) {

    // ----------------------------------------------------------------------------------
    // Regular `val` (NOT const) - runtime read-only property
    // ----------------------------------------------------------------------------------
    val info: String = "Car info for $model"  
    // `val` means immutable at runtime, but computed when the object is created
    // Not a compile-time constant

    companion object {
        // ---------------------------------------------------------------------------
        // `const val` inside companion object
        // Allows constant to behave like a static constant (like static final in Java)
        // ---------------------------------------------------------------------------
        const val MAX_SPEED = 260   // Available without creating an object instance
    }
}

fun main() {

    println("App version: $APP_VERSION")             // access top-level constant
    println("Max Car speed: ${Car.MAX_SPEED}")       // access const inside companion

    val car = Car("BMW", 2024)
    println(car.info)
    // println(Car.info)  // ❌ cannot access, because it's NOT static
}
