// ===========================================================
// Example: Interfaces with Default Implementations in Kotlin
// ===========================================================

// Interface with abstract and default methods
interface Drivable {

    // Abstract method: must be implemented
    fun start()

    // Method with default implementation
    fun stop() {
        println("The vehicle has stopped (default implementation).")
    }
}

// Interface with default property (via getter)
interface FuelConsumer {
    val fuelCapacity: Int
        get() = 50  // Default value

    fun refuel() {
        println("Refueling vehicle up to $fuelCapacity liters")
    }
}

// Class implementing interfaces
class Car : Drivable, FuelConsumer {

    // Must implement abstract method from Drivable
    override fun start() {
        println("Car engine started! Vroom Vroom!")
    }

    // Optional: can override default methods
    override fun stop() {
        println("Car has safely stopped at the parking lot.")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val myCar = Car()

    myCar.start()   // Calls overridden start()
    myCar.stop()    // Calls overridden stop() (not mandatory)
    myCar.refuel()  // Calls default method from FuelConsumer
    println("Fuel capacity: ${myCar.fuelCapacity}")  // Default property
}
