// ======================================================
// Example: Defining a class in Kotlin (class + constructor)
// ======================================================

// 1️⃣ Define a class with a primary constructor
class Person(val name: String, var age: Int) {
    // 'val' means the property is read-only (cannot be reassigned)
    // 'var' means the property is mutable (can be changed)

    // init block runs right after the primary constructor
    init {
        println("A Person object is created for $name, age $age")
    }

    // Class function (method)
    fun introduce() {
        println("Hi, my name is $name and I am $age years old.")
    }
}

// ======================================================
// MAIN FUNCTION — creating objects from these classes
// ======================================================
fun main() {
    // Create object using primary constructor
    val person1 = Person("Alice", 25)
    person1.introduce()
    person1.age = 26  // Modify mutable property

}
