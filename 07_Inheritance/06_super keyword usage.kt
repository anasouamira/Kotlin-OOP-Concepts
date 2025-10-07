// ===========================================================
// Example: Using the super keyword in Kotlin
// ===========================================================

// Parent class (base class)
open class Vehicle(val brand: String) {

    open fun start() {
        println("The vehicle from brand $brand is starting...")
    }

    open fun info() {
        println("Brand: $brand (from Vehicle class)")
    }
}

// Child class (subclass)
class Car(brand: String, val model: String) : Vehicle(brand) {

    // Override start() function from parent
    override fun start() {
        println("The car $model is starting with key ignition...")
        // Call the parent's version of start()
        super.start()
    }

    // Override info() but extend it using super
    override fun info() {
        // Call parent info first
        super.info()
        println("Model: $model (from Car class)")
    }

    fun displayFullInfo() {
        // Can also use super explicitly inside a child method
        println("Accessing parent function from child class using super:")
        super.info()
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val car = Car("Toyota", "Corolla")

    car.start()          // Calls overridden start() in Car, then super.start()
    println("------------")
    car.info()           // Calls overridden info() and uses super.info()
    println("------------")
    car.displayFullInfo() // Demonstrates calling super explicitly
}
