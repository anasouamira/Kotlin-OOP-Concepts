// ======================================================
// Example: Backing fields (field keyword) in Kotlin
// ======================================================

class Person {

    // Property with custom getter and setter
    var name: String = "Unknown"
        set(value) {
            // 'field' refers to the hidden storage location of this property
            if (value.isNotEmpty()) {
                field = value   // store the new value in the backing field
            } else {
                println("Name cannot be empty.")
            }
        }

        get() {
            // 'field' holds the current value of the property
            println("Getting name...")
            return field.uppercase()   // return the value in uppercase
        }

    // Property without custom logic – Kotlin generates a default backing field
    var age: Int = 0
}


// ======================================================
// MAIN FUNCTION — testing backing field usage
// ======================================================
fun main() {
    val person1 = Person()

    // Setter will be called
    person1.name = "Alice"   // ✅ valid
    println(person1.name)    // Getter called, prints uppercase

    // Invalid assignment (empty string)
    person1.name = ""        // ❌ Setter prevents it

    // 'age' uses default backing field automatically
    person1.age = 25
    println("Age: ${person1.age}")
}
