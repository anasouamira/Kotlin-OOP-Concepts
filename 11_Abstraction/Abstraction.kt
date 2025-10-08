// ===========================================================
// Example: Abstraction in Kotlin using Abstract Class & Interface
// ===========================================================

// Abstract class: provides blueprint for vehicles
abstract class Vehicle(val brand: String) {

    // Abstract function: implementation hidden from user
    abstract fun startEngine()

    // Concrete function: can be shared among all subclasses
    fun info() {
        println("Vehicle brand: $brand")
    }
}

// Interface: provides blueprint for Drivable behavior
interface Drivable {
    fun drive()        // Abstract: must be implemented
    fun stop() {       // Default implementation
        println("Vehicle has stopped (default from interface).")
    }
}

// Subclass: Car inherits abstract class & implements interface
class Car(brand: String) : Vehicle(brand), Drivable {

    // Must override abstract function from Vehicle
    override fun startEngine() {
        println("Car engine started! Brand: $brand")
    }

    // Must implement abstract function from Drivable
    override fun drive() {
        println("Car is now driving...")
    }

    // Optionally override stop() from interface
    override fun stop() {
        println("Car has safely stopped at the parking lot.")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val car = Car("Toyota")

    // Using abstraction: user doesn't know internal implementation
    car.startEngine()
    car.drive()
    car.stop()
    car.info()
}
// ===========================================================