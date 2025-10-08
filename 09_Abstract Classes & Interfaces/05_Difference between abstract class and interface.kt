// Abstract class
abstract class Vehicle(val brand: String) {

    abstract val maxSpeed: Int // Abstract property

    abstract fun start()       // Abstract function

    fun info() {               // Concrete function
        println("Brand: $brand, Max speed: $maxSpeed")
    }
}

// Interface
interface Drivable {
    fun start()                 // Abstract function

    fun stop() {                // Default implementation
        println("Vehicle stopped")
    }
}

// Class implementing both
class Car(brand: String, override val maxSpeed: Int) : Vehicle(brand), Drivable {

    override fun start() {
        println("Car started! Brand: $brand, Max speed: $maxSpeed")
    }

    override fun stop() {
        println("Car has safely stopped")
    }
}

// MAIN
fun main() {
    val car = Car("Toyota", 180)
    car.start()  // Overridden from both abstract class and interface
    car.stop()   // Interface default overridden
    car.info()   // Concrete function from abstract class
}
