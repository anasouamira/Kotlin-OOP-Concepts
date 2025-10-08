// AccessModifiers_Project.kt
// Kotlin project demonstrating Access/Visibility Modifiers

class Gadget(private val serialNumber: String, public var model: String) {
    public var status: String = "Inactive"
    private var secretKey: Int = 9876
    protected var firmwareVersion: String = "1.0.0"
    internal var internalId: Int = 1001

    fun showInfo(): String {
        return "Gadget(model=$model, status=$status, serialNumber=$serialNumber, firmwareVersion=$firmwareVersion, internalId=$internalId)"
    }

    private fun revealSecret() = println("Secret key is $secretKey")
}

class SmartGadget(serialNumber: String, model: String, val feature: String) : Gadget(serialNumber, model) {
    fun showFirmware(): String {
        return "Firmware: $firmwareVersion" // protected accessible here
    }
}

fun main() {
    val g = Gadget("SN100", "BasicGadget")
    println(g.model) // public
    println(g.status) // public
    // println(g.serialNumber) // private: not accessible
    // println(g.firmwareVersion) // protected: not accessible from outside
    println(g.internalId) // internal: accessible within module

    val sg = SmartGadget("SN200", "SmartGadget", "AI")
    println(sg.model)
    println(sg.showFirmware()) // protected accessed via subclass method
}