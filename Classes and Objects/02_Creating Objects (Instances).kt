// ======================================================
// Example: Class members — Properties (variables) and Functions (methods)
// ======================================================

// Define a class called 'Person'
class Person {

    // ------------------------------
    // 🔹 Properties (variables)
    // ------------------------------

    // 'val' means read-only property (cannot be changed after initialization)
    val name: String = "Alice"

    // 'var' means mutable property (can be changed later)
    var age: Int = 25

    // ------------------------------
    // 🔹 Functions (methods)
    // ------------------------------

    // Method to display person's info
    fun displayInfo() {
        println("Name: $name, Age: $age")
    }

    // Method to increase the age
    fun haveBirthday() {
        age += 1
        println("Happy birthday $name! You are now $age years old.")
    }

    // Method that returns a value
    fun isAdult(): Boolean {
        return age >= 18
    }
}


// ======================================================
// MAIN FUNCTION — using class members
// ======================================================
fun main() {
    // Create an object of class Person
    val person1 = Person()

    // Access and print properties
    println("Initial name: ${person1.name}")
    println("Initial age: ${person1.age}")

    // Call methods
    person1.displayInfo()
    person1.haveBirthday()

    // Use method that returns a value
    if (person1.isAdult()) {
        println("${person1.name} is an adult.")
    } else {
        println("${person1.name} is not an adult.")
    }
}
