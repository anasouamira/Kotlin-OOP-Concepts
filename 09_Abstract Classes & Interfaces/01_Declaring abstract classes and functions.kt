// ===========================================================
// Example: Abstract Classes and Functions in Kotlin
// ===========================================================

// Abstract class: cannot be instantiated directly
abstract class Animal(val name: String) {

    // Abstract function: must be overridden in subclasses
    abstract fun makeSound()

    // Concrete function: can be used by subclasses directly
    fun sleep() {
        println("$name is sleeping...")
    }
}

// Subclass 1
class Dog(name: String) : Animal(name) {

    // Must override abstract function
    override fun makeSound() {
        println("$name says: Woof! Woof!")
    }
}

// Subclass 2
class Cat(name: String) : Animal(name) {

    override fun makeSound() {
        println("$name says: Meow~")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // ❌ Cannot create an instance of an abstract class
    // val a = Animal("Generic") // Error

    val dog = Dog("Rex")
    val cat = Cat("Luna")

    dog.makeSound()  // Calls Dog's implementation
    dog.sleep()      // Calls concrete function from Animal

    cat.makeSound()  // Calls Cat's implementation
    cat.sleep()      // Calls concrete function from Animal
}
