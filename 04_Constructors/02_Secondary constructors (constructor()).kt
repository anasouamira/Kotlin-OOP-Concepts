// ======================================================
// Example: Secondary constructors in Kotlin
// ======================================================

class Person {

    var name: String
    var age: Int

    // Primary constructor (optional)
    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
        println("Person created with name and age: $name, $age")
    }

    // Secondary constructor
    constructor(name: String) : this(name, 0) {  // calls primary constructor
        println("Person created with name only: $name")
    }

    // Function to display info
    fun showInfo() {
        println("Name: $name, Age: $age")
    }
}


// ======================================================
// MAIN FUNCTION — testing secondary constructors
// ======================================================
fun main() {

    // Using primary constructor
    val person1 = Person("Alice", 25)
    person1.showInfo()

    // Using secondary constructor
    val person2 = Person("Bob")
    person2.showInfo()
}
