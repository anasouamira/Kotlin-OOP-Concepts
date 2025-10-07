// ======================================================
// Simple Example: No Destructors in Kotlin
// ======================================================

class Car(val model: String) {

    // This block runs when an object is created
    init {
        println("🚗 Car object created → Model: $model")
    }

    // Property to represent if the car engine is on
    var engineOn: Boolean = false

    // Function to start the car
    fun startEngine() {
        engineOn = true
        println("🔑 Engine started for $model")
    }

    // Function to stop the car
    fun stopEngine() {
        engineOn = false
        println("🛑 Engine stopped for $model")
    }

    // Custom cleanup function (manual)
    fun cleanUp() {
        println("🧹 Cleaning up $model before removing it from memory.")
    }
}


// ======================================================
// MAIN FUNCTION — understanding object destruction
// ======================================================
fun main() {

    // Create a car object
    var myCar = Car("Toyota")

    // Use the object
    myCar.startEngine()
    myCar.stopEngine()

    // Clean it manually before deletion
    myCar.cleanUp()

    // Remove reference (object can now be destroyed by GC)
    myCar = null

    println("🧠 The object is no longer referenced, GC will delete it automatically.")
}
