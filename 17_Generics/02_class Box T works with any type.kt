// Generic class Box that can store any type
class Box<T>(var value: T) {

    fun show() {
        println("Stored value: $value")
    }
}

fun main() {
    val intBox = Box(200)        // Works with Int
    val stringBox = Box("Hello") // Works with String

    intBox.show()
    stringBox.show()
}
