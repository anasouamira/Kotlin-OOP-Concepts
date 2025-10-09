// DataClasses_Project.kt
// Kotlin project demonstrating Data Classes and their features

// ===============================
// Data class declaration
// ===============================
data class User(val id: Int, val name: String, val email: String)

// ===============================
// Main function demonstrating features
// ===============================
fun main() {
    // Creating instances (objects) of data class
    val user1 = User(1, "Alice", "alice@example.com")
    val user2 = User(2, "Bob", "bob@example.com")
    val user3 = User(1, "Alice", "alice@example.com")

    // toString() auto-generated
    println("User1: $user1")

    // equals() auto-generated (value-based equality)
    println("user1 == user3: ${user1 == user3}")
    println("user1 == user2: ${user1 == user2}")

    // hashCode() auto-generated
    println("HashCode of user1: ${user1.hashCode()}")

    // copy() function
    val user4 = user1.copy(name = "Alice Cooper")
    println("Copied User4: $user4")

    // componentN() functions for destructuring
    val (id, name, email) = user2
    println("Destructured User2 -> id: $id, name: $name, email: $email")

    // Use case: list of DTOs
    val usersList = listOf(user1, user2, user4)
    println("All users:")
    usersList.forEach { println(it) }
}
