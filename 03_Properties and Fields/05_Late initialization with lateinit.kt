// ======================================================
// Example: Late initialization with lateinit in Kotlin
// ======================================================

class Person {

    // Property declared with 'lateinit' — must be initialized before use
    lateinit var name: String

    // Function to initialize the property
    fun initializeName(value: String) {
        name = value
    }

    // Function to display the property
    fun showName() {
        // Check if 'name' has been initialized
        if (::name.isInitialized) {
            println("Person's name: $name")
        } else {
            println("Name has not been initialized yet.")
        }
    }
}


// ======================================================
// MAIN FUNCTION — testing lateinit property
// ======================================================
fun main() {
    val person1 = Person()

    // Access before initialization
    person1.showName()  // prints "Name has not been initialized yet."

    // Initialize the property
    person1.initializeName("Alice")

    // Access after initialization
    person1.showName()  // prints "Person's name: Alice"

    // Direct assignment also works
    person1.name = "Bob"
    person1.showName()  // prints "Person's name: Bob"
}
