// ======================================================
// Example: Read-only properties (val) in Kotlin
// ======================================================

class Circle(val radius: Double) { // 'val' property defined in the constructor

    // Read-only property — computed based on radius
    val area: Double
        get() = 3.14 * radius * radius   // computed every time we access it

    // Function to display information
    fun showInfo() {
        println("Radius: $radius, Area: $area")
    }
}


// ======================================================
// MAIN FUNCTION — testing read-only properties
// ======================================================
fun main() {
    val circle1 = Circle(5.0)

    // Accessing read-only properties
    circle1.showInfo()

    // 'val' properties cannot be reassigned
    // circle1.radius = 10.0   ❌ ERROR: Val cannot be reassigned
    // circle1.area = 20.0     ❌ ERROR: Val cannot be reassigned
}
