// PropertiesAndFields_Project.kt
// Kotlin project demonstrating Properties and Fields

class Laptop(val brand: String, var model: String) {
    // Mutable property
    var status: String = "Off"

    // Read-only property
    val serialNumber: String = "SN123456"

    // Property with custom getter and setter, using backing field
    var batteryPercentage: Int = 100
        get() = field
        set(value) {
            field = when {
                value < 0 -> 0
                value > 100 -> 100
                else -> value
            }
        }

    // lateinit property for late initialization
    lateinit var owner: String

    // Constant property
    companion object {
        const val warrantyYears = 2
    }

    fun showInfo(): String {
        val ownerName = if (::owner.isInitialized) owner else "No owner"
        return "Laptop(brand=$brand, model=$model, status=$status, battery=$batteryPercentage%, owner=$ownerName, warranty=$warrantyYears years)"
    }
}

fun main() {
    val l1 = Laptop("Dell", "XPS 13")
    println(l1.showInfo())

    l1.status = "On"
    l1.batteryPercentage = 120 // custom setter adjusts to 100
    l1.owner = "Alice" // lateinit initialization

    println(l1.showInfo())

    // Access constant
    println("Warranty: ${Laptop.warrantyYears} years")
}
