// ======================================================
// Example: Difference between Class and Object in Kotlin
// ======================================================

// 🔹 CLASS — is a blueprint or template
// It defines how objects will look and behave
class Car {

    // Properties (variables)
    var brand: String = ""
    var year: Int = 0

    // Function (method)
    fun showInfo() {
        println("Brand: $brand, Year: $year")
    }
}


// ======================================================
// MAIN FUNCTION — creating and using objects
// ======================================================
fun main() {

    // 🔹 OBJECT — is an instance of a class
    // Each object has its own separate data

    val car1 = Car()   // first object
    car1.brand = "Toyota"
    car1.year = 2020

    val car2 = Car()   // second object
    car2.brand = "BMW"
    car2.year = 2023

    // Display info for each object
    car1.showInfo()
    car2.showInfo()

    // Even if both are from the same class,
    // they hold different data and act independently
}
