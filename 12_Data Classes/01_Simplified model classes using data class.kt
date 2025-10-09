// ===========================================================
// Example: Data Classes in Kotlin
// ===========================================================

// A simple model class for a Book
data class Book(
    val title: String,
    val author: String,
    val year: Int,
    var price: Double
)

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Creating instances of data class
    val book1 = Book("Kotlin Programming", "John Doe", 2024, 49.99)
    val book2 = Book("Advanced Kotlin", "Jane Smith", 2025, 59.99)

    // Accessing properties directly
    println("Book1: $book1")
    println("Title: ${book1.title}, Author: ${book1.author}")

    // Copying with modification
    val discountedBook = book1.copy(price = 39.99)
    println("Discounted Book: $discountedBook")

    // Comparing data class instances
    val anotherBook1 = Book("Kotlin Programming", "John Doe", 2024, 49.99)
    println("book1 == anotherBook1? ${book1 == anotherBook1}") // true, structural equality

    // Using destructuring
    val (title, author, year, price) = book2
    println("Destructured: $title, $author, $year, $price")
}
