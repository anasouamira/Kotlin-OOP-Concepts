// ===========================================================
// Example: Calling the parent constructor in Kotlin
// ===========================================================

// Base class with a constructor that takes a parameter
open class Person(val name: String) {

    init {
        println("👤 Person created with name: $name")
    }

    open fun greet() {
        println("Hello, my name is $name")
    }
}


// Subclass that calls the parent constructor
class Student(name: String, val grade: Int) : Person(name) {

    init {
        println("🎓 Student enrolled with grade: $grade")
    }

    override fun greet() {
        println("Hello, I am $name and I am in grade $grade")
    }
}


// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Creating a Student object
    val student = Student("Alice", 10)

    // Calling the overridden function
    student.greet()
}
