// ======================================================
// Example: Custom getters and setters in Kotlin
// ======================================================

class Person {

    // Property with a custom setter and getter
    var age: Int = 0
        // Custom setter — runs when we assign a new value
        set(value) {
            if (value >= 0) {   // ensure age is not negative
                field = value   // 'field' refers to the backing field of 'age'
            } else {
                println("Age cannot be negative.")
            }
        }

        // Custom getter — runs when we read the value
        get() {
            println("Getting age value...")
            return field
        }

    // Property with only a custom getter (read-only logic)
    val isAdult: Boolean
        get() = age >= 18     // computed property (no backing field)
}


// ======================================================
// MAIN FUNCTION — testing custom getters and setters
// ======================================================
fun main() {
    val person1 = Person()

    // Setting the value (setter will be called)
    person1.age = 25    // ✅ OK
    println("Age is: ${person1.age}")  // getter called

    // Try setting a negative value
    person1.age = -5    // ❌ Custom setter prevents invalid data

    // Using computed property
    println("Is adult? ${person1.isAdult}")
}
