// Example class demonstrating companion object (unnamed and named)
class Student {

    // Unnamed companion object (default)
    companion object {
        // Static-like property
        var studentCount: Int = 0

        // Static-like method
        fun registerStudent(): Int {
            studentCount++
            return studentCount
        }
    }
}

class Book {

    // Named companion object
    companion object Factory {
        // Factory method to create Book objects
        fun create(title: String): Book {
            println("Book created: $title")
            return Book()
        }
    }
}

fun main() {
    // Using unnamed companion object
    println(Student.registerStudent())
    println(Student.registerStudent())

    // Using named companion object
    val b1 = Book.create("Kotlin Programming")

    // Demonstrating access by name (optional)
    val b2 = Book.Factory.create("OOP Concepts")
}
