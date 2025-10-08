// CompanionObject_Project.kt
// Kotlin project demonstrating static members alternative using companion object

class User(val username: String) {
    // Instance property
    var isLoggedIn: Boolean = false

    fun login() {
        isLoggedIn = true
        println("$username logged in. Total users online: ${User.onlineUsers}")
    }

    fun logout() {
        isLoggedIn = false
        println("$username logged out. Total users online: ${User.onlineUsers}")
    }

    companion object {
        // Acts like static members in Java
        var onlineUsers: Int = 0

        fun userConnected() {
            onlineUsers++
            println("[COMPANION] A new user connected. Current online: $onlineUsers")
        }

        fun userDisconnected() {
            if (onlineUsers > 0) onlineUsers--
            println("[COMPANION] A user disconnected. Current online: $onlineUsers")
        }

        fun platformInfo(): String {
            return "Welcome to KotlinChat - current users: $onlineUsers"
        }
    }
}

fun main() {
    println(User.platformInfo())

    val u1 = User("Alice")
    val u2 = User("Bob")

    User.userConnected()
    u1.login()

    User.userConnected()
    u2.login()

    println(User.platformInfo())

    u1.logout()
    User.userDisconnected()

    println(User.platformInfo())
}