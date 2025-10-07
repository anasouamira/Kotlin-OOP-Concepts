// ======================================================
// Example: Using close() and use{} for Resources in Kotlin
// ======================================================

// A simple class that represents a file-like resource
class FileReader(val fileName: String) : AutoCloseable {

    // This block runs when the object is created
    init {
        println("📂 Opening file: $fileName")
    }

    // Function to read data from the file (simulated)
    fun readData() {
        println("📖 Reading data from $fileName ...")
    }

    // The close() function comes from AutoCloseable interface
    // It is used to clean up or close the resource when done
    override fun close() {
        println("❌ Closing file: $fileName")
    }
}


// ======================================================
// MAIN FUNCTION — understanding close() and use{}
// ======================================================
fun main() {

    // 🔹 Example 1: Manual close() (less safe)
    println("=== Manual close() example ===")
    val reader1 = FileReader("data.txt")
    reader1.readData()
    reader1.close()  // must be called manually

    println("--------------------------------------")

    // 🔹 Example 2: Automatic close with use{} (safe way)
    println("=== Automatic close() using use{} ===")
    FileReader("config.txt").use { reader2 ->
        reader2.readData()
        println("Inside use block — resource is active.")
    } // Automatically calls close() here

    println("✅ Program finished — all resources closed.")
}
