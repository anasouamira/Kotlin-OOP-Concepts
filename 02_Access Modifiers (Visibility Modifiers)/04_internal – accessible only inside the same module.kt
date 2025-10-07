// ======================================================
// Example: internal modifier in Kotlin
// ======================================================

// Define a class with internal members
class Person {

    // Internal property – accessible anywhere inside the same module
    internal var name: String = "Alice"

    // Internal function – accessible anywhere inside the same module
    internal fun introduce() {
        println("Hi, my name is $name.")
    }
}


// ======================================================
// MAIN FUNCTION — accessing internal members in the same module
// ======================================================
fun main() {
    val person1 = Person()

    // Access internal property
    person1.name = "Bob"
    println(person1.name)

    // Call internal function
    person1.introduce()
}
