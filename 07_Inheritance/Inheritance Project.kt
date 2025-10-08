// Inheritance_Project.kt
// Kotlin project demonstrating Inheritance concepts in a complex hierarchy

// ===============================
// Base class (open keyword allows inheritance)
// ===============================
open class Device(protected val brand: String, internal val model: String) {
    open var powerStatus: Boolean = false

    // Open function to allow overriding in subclasses
    open fun turnOn() {
        powerStatus = true
        println("[$brand $model] Device is now ON.")
    }

    open fun turnOff() {
        powerStatus = false
        println("[$brand $model] Device is now OFF.")
    }

    open fun deviceInfo(): String {
        return "Brand: $brand | Model: $model | Power: ${if (powerStatus) "ON" else "OFF"}"
    }
}

// ===============================
// First Level Inheritance
// ===============================
open class SmartDevice(brand: String, model: String, var connectivity: String) : Device(brand, model) {

    override fun turnOn() {
        super.turnOn() // call parent function using 'super'
        println("[$brand $model] Connecting to $connectivity network...")
    }

    override fun turnOff() {
        println("[$brand $model] Disconnecting from network...")
        super.turnOff()
    }

    override fun deviceInfo(): String {
        return super.deviceInfo() + " | Connectivity: $connectivity"
    }
}

// ===============================
// Second Level Inheritance (multi-level)
// ===============================
class SmartThermostat(brand: String, model: String, connectivity: String, var temperature: Int) : SmartDevice(brand, model, connectivity) {

    // Override methods and extend behavior
    override fun turnOn() {
        super.turnOn()
        println("[$brand $model] Heating system started at $temperature°C.")
    }

    override fun deviceInfo(): String {
        return super.deviceInfo() + " | Temperature: $temperature°C"
    }

    fun adjustTemperature(newTemp: Int) {
        println("[$brand $model] Adjusting temperature from $temperature°C to $newTemp°C.")
        temperature = newTemp
    }
}

// ===============================
// Third Level Inheritance (further extension)
// ===============================
class AIEnabledThermostat(brand: String, model: String, connectivity: String, temperature: Int, val aiVersion: String)
    : SmartThermostat(brand, model, connectivity, temperature) {

    override fun turnOn() {
        println("[AI System] Booting AI version $aiVersion...")
        super.turnOn()
    }

    override fun deviceInfo(): String {
        return super.deviceInfo() + " | AI Version: $aiVersion"
    }

    fun autoAdjustBasedOnRoom() {
        println("[$brand $model] (AI $aiVersion) analyzing room conditions and adjusting temperature...")
        temperature += 2
        println("[$brand $model] New temperature set to $temperature°C.")
    }
}

// ===============================
// Main Function
// ===============================
fun main() {
    println("===== Multi-Level Inheritance Demonstration =====")

    val aiThermostat = AIEnabledThermostat("Nest", "T3007ES", "WiFi", 22, "2.1 Pro")

    println("\n--- Turning On ---")
    aiThermostat.turnOn()

    println("\n--- Adjusting Temperature ---")
    aiThermostat.adjustTemperature(25)

    println("\n--- AI Auto Adjustment ---")
    aiThermostat.autoAdjustBasedOnRoom()

    println("\n--- Device Information ---")
    println(aiThermostat.deviceInfo())

    println("\n--- Turning Off ---")
    aiThermostat.turnOff()
}