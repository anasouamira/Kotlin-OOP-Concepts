// ======================================================
// Example: Declaring properties using var and val
// ======================================================

class Person {

    // 'var' property — mutable (can be changed)
    var name: String = "Alice"

    // 'val' property — read-only (cannot be changed after initialization)
    val birthYear: Int = 2000

    // Function to display info
    fun showInfo() {
        println("Name: $name, Birth Year: $birthYear")
    }
}


// ======================================================
// MAIN FUNCTION — testing var and val properties
// ======================================================
fun main() {
    val person1 = Person()

    // Access both properties
    person1.showInfo()

    // We can change the 'var' property because it's mutable
    person1.name = "Bob"   // ✅ allowed

    // We CANNOT change the 'val' property because it's read-only
    // person1.birthYear = 1999  ❌ ERROR: Val cannot be reassigned

    person1.showInfo()
}
