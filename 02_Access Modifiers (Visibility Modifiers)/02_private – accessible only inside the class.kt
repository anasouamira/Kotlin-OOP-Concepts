// ======================================================
// Example: private modifier in Kotlin
// ======================================================

class Person {

    // Private property – accessible only inside this class
    private var age: Int = 25

    // Public property – accessible anywhere
    var name: String = "Alice"

    // Private function – accessible only inside this class
    private fun showAge() {
        println("Age: $age")
    }

    // Public function – can access private members inside the class
    fun introduce() {
        println("Hi, my name is $name.")
        showAge()  // calling private function inside the class
    }
}


// ======================================================
// MAIN FUNCTION — testing private access
// ======================================================
fun main() {
    val person1 = Person()

    // Access public property
    person1.name = "Bob"
    println(person1.name)

    // Access public function
    person1.introduce()

    // The following lines would cause errors:
    // person1.age          ❌ cannot access private property
    // person1.showAge()    ❌ cannot call private function
}
