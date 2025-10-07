// ======================================================
// Example: finalize() replaced by try-with-resources (use{})
// ======================================================

// A simple class that simulates a resource (like a file or network connection)
class Connection(val name: String) : AutoCloseable {

    // Initialization block – runs when the object is created
    init {
        println("🔌 Connection '$name' opened.")
    }

    // Simulated action with the resource
    fun sendData(message: String) {
        println("📤 Sending message through '$name': $message")
    }

    // The close() method from AutoCloseable
    // It replaces the old finalize() cleanup behavior
    override fun close() {
        println("❌ Connection '$name' closed and cleaned up.")
    }
}


// ======================================================
// MAIN FUNCTION — demonstrating modern resource cleanup
// ======================================================
fun main() {

    println("=== Old Way: finalize() concept (no longer used) ===")
    // In Java/Kotlin before: cleanup was done by finalize()
    // But finalize() was unreliable and slow.
    // Now we avoid it completely.

    println("-------------------------------------------")

    println("=== Modern Way: try-with-resources using use{} ===")
    // 'use {}' automatically calls close() at the end of the block
    Connection("ServerConnection").use { conn ->
        conn.sendData("Hello from Kotlin!")
        println("✅ Still inside use block.")
    } // close() is called automatically here!

    println("🏁 Program finished safely — resource closed automatically.")
}
