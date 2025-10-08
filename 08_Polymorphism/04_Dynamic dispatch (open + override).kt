// ===========================================================
// Example: Dynamic Dispatch using 'open' + 'override'
// ===========================================================

// Base class
open class Employee(val name: String) {

    // Open function that can be overridden
    open fun calculateBonus(): Double {
        println("Calculating generic employee bonus...")
        return 500.0
    }

    open fun showRole() {
        println("$name is a generic employee.")
    }
}

// Derived class 1
class Manager(name: String, private val teamSize: Int) : Employee(name) {

    // Override parent function
    override fun calculateBonus(): Double {
        println("Calculating Manager bonus based on team size...")
        return 500.0 + (teamSize * 100)
    }

    override fun showRole() {
        println("$name is a Manager of $teamSize employees.")
    }
}

// Derived class 2
class Developer(name: String, private val projects: Int) : Employee(name) {

    override fun calculateBonus(): Double {
        println("Calculating Developer bonus based on project count...")
        return 500.0 + (projects * 150)
    }

    override fun showRole() {
        println("$name is a Developer working on $projects projects.")
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Parent reference can hold any child object
    val employees: List<Employee> = listOf(
        Manager("Alice", 5),
        Developer("Bob", 3),
        Employee("Charlie")
    )

    // Dynamic dispatch in action:
    // The method that runs is determined at RUNTIME based on the actual object type
    for (emp in employees) {
        emp.showRole()
        println("Bonus = ${emp.calculateBonus()}")
        println("------------")
    }
}
