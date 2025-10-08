// AbstractInterfaces_Project.kt
// Kotlin project demonstrating Abstract Classes & Interfaces concepts

// ===============================
// Abstract class
// ===============================
abstract class Appliance(val brand: String) {
    abstract var power: Boolean

    abstract fun turnOn()
    abstract fun turnOff()

    fun applianceInfo(): String {
        return "Appliance brand: $brand | Power: ${if (power) "ON" else "OFF"}"
    }
}

// ===============================
// Interface with default implementation
// ===============================
interface RemoteControl {
    fun increasePower()
    fun decreasePower()

    fun batteryCheck() {
        println("Remote battery is OK.")
    }
}

interface SmartFeatures {
    fun connectWiFi()
    fun disconnectWiFi() {
        println("Disconnecting from WiFi.")
    }
}

// ===============================
// Concrete class implementing abstract class and multiple interfaces
// ===============================
class SmartFan(brand: String) : Appliance(brand), RemoteControl, SmartFeatures {
    override var power: Boolean = false
    private var speed: Int = 1

    // Overriding abstract class members
    override fun turnOn() {
        power = true
        println("$brand Fan is ON")
    }

    override fun turnOff() {
        power = false
        println("$brand Fan is OFF")
    }

    // Implementing interfaces
    override fun increasePower() {
        speed++
        println("$brand Fan speed increased to $speed")
    }

    override fun decreasePower() {
        if (speed > 1) speed--
        println("$brand Fan speed decreased to $speed")
    }

    override fun connectWiFi() {
        println("$brand Fan connected to WiFi")
    }

    // disconnectWiFi() uses default implementation from interface SmartFeatures
}

// ===============================
// Main function
// ===============================
fun main() {
    val fan = SmartFan("CoolBreeze")

    println("--- Appliance Info ---")
    println(fan.applianceInfo())

    println("\n--- Power Control ---")
    fan.turnOn()
    fan.increasePower()
    fan.decreasePower()
    fan.turnOff()

    println("\n--- Smart Features ---")
    fan.connectWiFi()
    fan.disconnectWiFi()

    println("\n--- Remote Control Check ---")
    fan.batteryCheck()
}