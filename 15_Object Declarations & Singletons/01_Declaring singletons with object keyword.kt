// Declaring a Singleton using 'object'
object Logger {
    // Property to count number of logs
    private var logCount: Int = 0

    // Function to print a log message
    fun log(message: String) {
        logCount++
        println("LOG #$logCount: $message")
    }

    // Function to get current count
    fun getLogCount(): Int {
        return logCount
    }
}

// Example class using the Logger
class User(val name: String) {

    fun signIn() {
        // Log when the user signs in
        Logger.log("User $name signed in")
    }

    fun signOut() {
        // Log when the user signs out
        Logger.log("User $name signed out")
    }
}

fun main() {
    // Accessing the Singleton (no need to create instance)
    Logger.log("Application started")

    val user1 = User("Ali")
    user1.signIn()

    val user2 = User("Sara")
    user2.signIn()
    user2.signOut()

    // Calling another log directly
    Logger.log("Application closing...")

    // Print total number of logs
    println("Total logs created: ${Logger.getLogCount()}")
}
