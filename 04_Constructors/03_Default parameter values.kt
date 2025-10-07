// ======================================================
// Example: Default parameter values in Kotlin
// ======================================================

class Person(val name: String = "Unknown", var age: Int = 0) {

    // Function with default parameter values
    fun greet(greeting: String = "Hello") {
        println("$greeting, my name is $name and I am $age years old.")
    }
}


// ======================================================
// MAIN FUNCTION — testing default parameters
// ======================================================
fun main() {

    // Using default constructor values
    val person1 = Person()
    person1.greet()    // Uses default name, age, and greeting

    // Providing some values
    val person2 = Person("Alice")
    person2.greet()    // Uses default age and greeting

    // Providing all values
    val person3 = Person("Bob", 30)
    person3.greet("Hi")   // Uses all custom values
}
