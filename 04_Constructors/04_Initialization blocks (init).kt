// ======================================================
// Complex Example: Initialization blocks (init) in Kotlin
// ======================================================

class Employee(
    val name: String,
    var age: Int = 25,             // Default value
    var salary: Double = 3000.0    // Default value
) {
    // Computed property with custom getter
    val isAdult: Boolean
        get() = age >= 18

    // Mutable property with validation using custom setter
    var department: String = "General"
        set(value) {
            if (value.isNotBlank()) {
                field = value
            } else {
                println("Invalid department. Keeping previous value: $field")
            }
        }

    // First init block: basic info
    init {
        println("Init1: Creating Employee: $name, Age: $age, Salary: $salary")
    }

    // Second init block: validation
    init {
        if (age < 0) {
            println("Init2: Age cannot be negative. Setting age to 0.")
            age = 0
        }
        if (salary < 0) {
            println("Init2: Salary cannot be negative. Setting salary to 0.")
            salary = 0.0
        }
    }

    // Function to show full info
    fun showInfo() {
        println(
            "Name: $name, Age: $age, Salary: $salary, Department: $department, Adult: $isAdult"
        )
    }
}


// ======================================================
// MAIN FUNCTION — testing complex init blocks
// ======================================================
fun main() {

    // Using primary constructor with all default values
    val emp1 = Employee("Alice")
    emp1.showInfo()

    // Using primary constructor with custom values
    val emp2 = Employee("Bob", -5, -1000.0)  // triggers validation in init
    emp2.showInfo()

    // Changing department with setter validation
    emp2.department = ""        // invalid input
    emp2.department = "IT"      // valid input
    emp2.showInfo()
}
