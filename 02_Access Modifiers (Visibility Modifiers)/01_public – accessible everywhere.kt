// ======================================================
// Example: public modifier in Kotlin
// ======================================================

// Define a class with public members
class Person {

    // Public property – accessible from anywhere
    public var name: String = "Alice"

    // Public function – accessible from anywhere
    public fun introduce() {
        println("Hi, my name is $name.")
    }
}


// ======================================================
// MAIN FUNCTION — accessing public members
// ======================================================
fun main() {
    val person1 = Person()    // Create an object

    // Access public property
    person1.name = "Bob"
    println(person1.name)

    // Call public function
    person1.introduce()
}
