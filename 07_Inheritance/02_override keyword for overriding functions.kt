// ===========================================================
// Example: Using 'override' keyword in Kotlin
// ===========================================================

// Base class (must be open to allow overriding)
open class Vehicle {

    // Open function that can be overridden
    open fun start() {
        println("🚗 Vehicle is starting...")
    }

    // Normal function (not open) — cannot be overridden
    fun stop() {
        println("🛑 Vehicle has stopped.")
    }
}


// Subclass that inherits from Vehicle
class Motorcycle : Vehicle() {

    // Overriding the open function from Vehicle
    override fun start() {
        println("🏍️ Motorcycle is revving its engine and starting!")
    }

    // stop() cannot be overridden because it is not open in the base class
}


// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val myVehicle: Vehicle = Vehicle()
    myVehicle.start()   // Calls Vehicle's start()
    myVehicle.stop()    // Calls Vehicle's stop()

    println("----------------------------------------")

    val myMotorcycle: Vehicle = Motorcycle()
    myMotorcycle.start()  // Calls overridden start() in Motorcycle
    myMotorcycle.stop()   // Calls inherited stop() from Vehicle
}
