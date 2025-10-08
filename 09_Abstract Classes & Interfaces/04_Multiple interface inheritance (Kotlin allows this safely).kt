// ===========================================================
// Example: Multiple Interface Inheritance in Kotlin
// ===========================================================

// First interface
interface Drivable {
    fun start()
    fun stop() {
        println("Vehicle stopped (Drivable default)")
    }
}

// Second interface
interface FuelConsumer {
    val fuelCapacity: Int
        get() = 50

    fun refuel() {
        println("Refueling vehicle up to $fuelCapacity liters (FuelConsumer default)")
    }
}

// Third interface
interface GPS {
    fun navigate(destination: String) {
        println("Navigating to $destination (default GPS)")
    }
}

// Class implementing multiple interfaces
class Car : Drivable, FuelConsumer, GPS {

    // Must implement abstract methods
    override fun start() {
        println("Car engine started! Vroom Vroom!")
    }

    // Optionally override default methods if needed
    override fun stop() {
        println("Car has safely stopped at the parking lot.")
    }

    // Optional: can override navigate() or leave default
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val myCar = Car()

    myCar.start()           // Implemented method
    myCar.stop()            // Overridden default method
    myCar.refuel()          // Default implementation from FuelConsumer
    myCar.navigate("Paris") // Default implementation from GPS

    println("Fuel capacity: ${myCar.fuelCapacity}")  // Default property
}
