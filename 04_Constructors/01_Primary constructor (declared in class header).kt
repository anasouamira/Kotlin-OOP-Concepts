// ======================================================
// Example: Primary constructor in Kotlin
// ======================================================

// Primary constructor declared in the class header
class Person(val name: String, var age: Int) {

    // Initialization block (optional)
    init {
        println("Person created: $name, age $age")
    }

    // Function to display info
    fun showInfo() {
        println("Name: $name, Age: $age")
    }
}


// ======================================================
// MAIN FUNCTION — testing primary constructor
// ======================================================
fun main() {
    // Create objects using the primary constructor
    val person1 = Person("Alice", 25)
    val person2 = Person("Bob", 30)

    // Access properties
    println(person1.name)
    println(person2.age)

    // Call function
    person1.showInfo()
    person2.showInfo()
}
