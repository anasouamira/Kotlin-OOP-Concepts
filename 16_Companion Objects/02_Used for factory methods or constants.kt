// Class demonstrating factory methods and constants using companion object
class User private constructor(val name: String, val age: Int) {

    // Companion object holds factory functions and constants
    companion object {
        // Constant value
        const val MIN_AGE = 18

        // Factory method to create User with default age
        fun createWithDefaultAge(name: String): User {
            return User(name, MIN_AGE)
        }

        // Factory method to create User with custom age
        fun create(name: String, age: Int): User {
            return User(name, age)
        }
    }

    // Method just for printing details
    fun showInfo() {
        println("User name: $name, age: $age")
    }
}

fun main() {
    // Creating objects using factory methods (not direct constructor)
    val user1 = User.createWithDefaultAge("Ali")
    val user2 = User.create("Sara", 25)

    // Display user info
    user1.showInfo()
    user2.showInfo()

    // Accessing constant directly
    println("Minimum allowed age: ${User.MIN_AGE}")
}
