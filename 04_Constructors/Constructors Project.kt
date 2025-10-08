// Constructors_Project.kt
// Kotlin project demonstrating constructors in Kotlin (advanced version)

class Engine(val type: String, val horsepower: Int = 120) {
    init {
        println("Engine initialized: Type=$type, HP=$horsepower")
    }
}

class Car(val brand: String, val model: String, val year: Int = 2020) {
    var owner: String = "Unknown"
    var engine: Engine

    // init block executes after primary constructor
    init {
        println("[INIT] Building car: $brand $model ($year)")
        engine = Engine("Petrol") // default engine created
    }

    // Secondary constructor adds owner
    constructor(brand: String, model: String, year: Int, owner: String) : this(brand, model, year) {
        this.owner = owner
        println("[SECONDARY] Owner assigned: $owner")
    }

    // Another secondary constructor adds engine as well
    constructor(brand: String, model: String, year: Int, owner: String, engine: Engine) : this(brand, model, year, owner) {
        this.engine = engine
        println("[SECONDARY] Custom engine installed: ${engine.type} (${engine.horsepower} HP)")
    }

    fun carInfo(): String {
        return "Car(brand=$brand, model=$model, year=$year, owner=$owner, engine=${engine.type} ${engine.horsepower}HP)"
    }
}

fun main() {
    println("===== Using Primary Constructor =====")
    val car1 = Car("Toyota", "Corolla")
    println(car1.carInfo())

    println("\n===== Using Primary Constructor with Default Year =====")
    val car2 = Car("Honda", "Civic", 2023)
    println(car2.carInfo())

    println("\n===== Using Secondary Constructor (with Owner) =====")
    val car3 = Car("Tesla", "Model 3", 2024, "Alice")
    println(car3.carInfo())

    println("\n===== Using Secondary Constructor (with Owner and Engine) =====")
    val engine = Engine("Electric", 300)
    val car4 = Car("Porsche", "Taycan", 2025, "Bob", engine)
    println(car4.carInfo())
}
