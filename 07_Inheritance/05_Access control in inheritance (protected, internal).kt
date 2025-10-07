// ===========================================================
// Example: Access control in inheritance
// ===========================================================

// Base class demonstrating access control
open class Employee(val name: String) {

    // Protected property: accessible in subclass, not outside
    protected val salary: Double = 50000.0

    // Internal property: accessible within the same module
    internal val department: String = "Engineering"

    // Public function: accessible everywhere
    fun showInfo() {
        println("Employee name: $name")
    }
}

// Subclass inherits from Employee
class Manager(name: String, val teamSize: Int) : Employee(name) {

    fun showDetails() {
        // Can access protected property 'salary'
        println("Manager $name has salary: $salary")

        // Can access internal property 'department'
        println("Manager $name works in: $department")

        println("Manager $name leads a team of $teamSize people")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val manager = Manager("Alice", 5)

    manager.showInfo()      // Public, accessible everywhere
    manager.showDetails()   // Accessing protected/internal inside subclass

    // ❌ Cannot access protected property outside subclass
    // println(manager.salary) // Error

    // ✅ Can access internal property if in same module
    println("Department (internal): ${manager.department}")
}
