// ===========================================================
// Example: Multi-level inheritance in Kotlin
// ===========================================================

// Level 1: Base class
open class LivingBeing(val name: String) {

    init {
        println("🌱 LivingBeing created: $name")
    }

    open fun breathe() {
        println("$name is breathing.")
    }
}

// Level 2: Derived class
open class Animal(name: String, val species: String) : LivingBeing(name) {

    init {
        println("🐾 Animal created: $name, species: $species")
    }

    override fun breathe() {
        println("$name the $species is breathing through lungs.")
    }
}

// Level 3: Derived class of Animal
class Dog(name: String, val breed: String) : Animal(name, "Dog") {

    init {
        println("🐶 Dog created: $name, breed: $breed")
    }

    override fun breathe() {
        println("$name the $breed is breathing happily!")
    }

    fun bark() {
        println("$name barks: Woof! Woof!")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val myDog = Dog("Rex", "German Shepherd")

    myDog.breathe()  // Calls overridden method in Dog
    myDog.bark()     // Calls Dog-specific method
}
