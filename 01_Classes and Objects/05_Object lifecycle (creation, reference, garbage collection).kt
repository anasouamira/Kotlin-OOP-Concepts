// ======================================================
// Example: Object Lifecycle in Kotlin
// (Creation → Reference → Garbage Collection)
// ======================================================

class Book(val title: String) {

    // This block runs when an object is created
    init {
        println("📗 Book '$title' is created.")
    }

    // Function to show book title
    fun showTitle() {
        println("The book title is: $title")
    }

    // Optional: finalize-like message (simulated)
    fun onDestroy() {
        println("💨 Book '$title' is no longer referenced (ready for garbage collection).")
    }
}


// ======================================================
// MAIN FUNCTION — simulating object lifecycle
// ======================================================
fun main() {

    // 1️⃣ Object Creation
    var myBook: Book? = Book("Kotlin for Beginners")
    myBook?.showTitle()

    // 2️⃣ Object Reference
    var anotherRef: Book? = myBook
    anotherRef?.showTitle()

    // 3️⃣ Removing References (now valid)
    myBook = null
    anotherRef = null

    // 4️⃣ Garbage Collection (automatic in Kotlin)
    // The JVM automatically cleans up objects that have no references.
    // We can simulate this message manually:
    val tempBook = Book("Temporary Book")
    tempBook.onDestroy()
    // After this line, 'tempBook' goes out of scope and becomes eligible for GC.

    println("End of program — unused objects will be garbage collected automatically.")
}
