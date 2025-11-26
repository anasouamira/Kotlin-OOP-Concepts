// A normal class - can create many objects
class User(val name: String) {

    // Method inside class
    fun greet() {
        println("Hello, I am $name")
    }
}

// A singleton object - only one instance exists
object AppConfig {

    // Property
    var language: String = "English"

    // Initialization block runs once only
    init {
        println("AppConfig initialized")
    }

    // Method
    fun showConfig() {
        println("Current language: $language")
    }
}

fun main() {
    // Creating multiple instances of a class
    val user1 = User("Ali")
    val user2 = User("Sara")
    user1.greet() // Hello, I am Ali
    user2.greet() // Hello, I am Sara

    // Accessing singleton object (no instance creation)
    AppConfig.showConfig()  // triggers init once
    AppConfig.language = "Arabic"
    AppConfig.showConfig()
}
