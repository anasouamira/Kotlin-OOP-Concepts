// ===========================================================
// Example: Overriding Abstract Members in Kotlin
// ===========================================================

// Abstract base class
abstract class Vehicle(val brand: String) {

    // Abstract property: must be overridden
    abstract val maxSpeed: Int

    // Abstract function: must be overridden
    abstract fun startEngine()

    // Concrete function: can be used directly
    fun info() {
        println("Vehicle brand: $brand, max speed: $maxSpeed")
    }
}

// Subclass: Car
class Car(brand: String, override val maxSpeed: Int) : Vehicle(brand) {

    // Override the abstract function
    override fun startEngine() {
        println("🚗 Car engine started! Max speed: $maxSpeed km/h")
    }
}

// Subclass: Motorcycle
class Motorcycle(brand: String, override val maxSpeed: Int) : Vehicle(brand) {

    override fun startEngine() {
        println("🏍️ Motorcycle engine started! Max speed: $maxSpeed km/h")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val car = Car("Toyota", 180)
    val bike = Motorcycle("Yamaha", 120)

    car.startEngine()  // Calls Car's implementation
    car.info()         // Calls concrete function from Vehicle

    println("------------")

    bike.startEngine() // Calls Motorcycle's implementation
    bike.info()        // Calls concrete function from Vehicle
}
