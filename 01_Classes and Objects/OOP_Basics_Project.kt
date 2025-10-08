// OOP_Basics_Project.kt
// A focused Kotlin project that demonstrates ONLY the requested OOP concepts:
// - Classes and objects (class declarations, constructors)
// - Creating instances (objects)
// - Class members: properties and methods
// - Difference between a class and an object (Kotlin 'object' singleton used only to illustrate)
// - The 'this' keyword
// - Object lifecycle: creation, references, and notes about garbage collection

class Phone(val brand: String, modelName: String) {
    var model: String = modelName
    var poweredOn: Boolean = false

    constructor(brand: String) : this(brand, "Unknown") {
        println("Secondary constructor used for brand=$brand")
    }

    fun powerToggle() {
        this.poweredOn = !this.poweredOn
        println("${this.brand} ${this.model} is now ${if (this.poweredOn) "ON" else "OFF"}")
    }

    fun info(): String {
        return "Phone -> brand: ${this.brand}, model: ${this.model}, poweredOn: ${this.poweredOn}"
    }
}

object PhoneFactory {
    var createdCount: Int = 0
        private set

    fun create(brand: String, model: String): Phone {
        createdCount += 1
        return Phone(brand, model)
    }
}

fun main() {
    val p1 = Phone("Nokia", "3310")
    val p2 = Phone("Samsung")

    println(p1.info())
    p1.powerToggle()

    val p3 = PhoneFactory.create("XPhone", "X1")
    println("Created phones so far: ${PhoneFactory.createdCount}")

    val alias = p1
    println("alias info: ${alias.info()}")

    alias.model = "3310 Classic"
    println("After change via alias -> p1.info(): ${p1.info()}")

    var ref: Phone? = Phone("TempBrand", "T1")
    println("Temporary phone: ${ref?.info()}")

    ref = null

    println(p1.info())
    println(p2.info())
    println(p3.info())
    println("Total created by factory: ${PhoneFactory.createdCount}")
}
