// ===========================================================
// Example: Upcasting and Downcasting in Kotlin
// ===========================================================

// Base class
open class Animal {
    open fun speak() {
        println("The animal makes a sound")
    }
}

// Derived class 1
class Dog : Animal() {
    override fun speak() {
        println("The dog barks: Woof!")
    }

    fun fetch() {
        println("The dog fetches the ball")
    }
}

// Derived class 2
class Cat : Animal() {
    override fun speak() {
        println("The cat meows: Meow!")
    }

    fun climb() {
        println("The cat climbs a tree")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // -------------------------------
    // 🔹 Upcasting
    // -------------------------------
    val dog = Dog()

    // Upcasting: treating Dog as its parent type (Animal)
    val animal: Animal = dog
    animal.speak() // Calls Dog's version (polymorphism at runtime)

    // ❌ animal.fetch() // Error: not accessible, because the reference type is Animal

    println("------------")

    // -------------------------------
    // 🔹 Downcasting (unsafe casting)
    // -------------------------------

    // 'as' tries to cast explicitly
    val dogAgain = animal as Dog
    dogAgain.fetch() // Works fine since 'animal' really refers to a Dog object

    println("------------")

    // Safe cast using 'as?'
    val cat = animal as? Cat
    if (cat == null) {
        println("Safe cast failed: animal is not a Cat")
    }

    println("------------")

    // -------------------------------
    // 🔹 Type checking using 'is' and Smart Cast
    // -------------------------------

    val pet: Animal = Cat()

    if (pet is Cat) { // Type check
        // Smart cast: Kotlin automatically treats 'pet' as Cat here
        pet.climb() // No explicit casting needed
    } else if (pet is Dog) {
        pet.fetch()
    } else {
        pet.speak()
    }
}
