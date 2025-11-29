// Generic function that prints any type of element
fun <T> printItem(item: T) {
    println("Item: $item")
}

fun main() {
    printItem(100)            // T = Int
    printItem("Welcome")      // T = String
    printItem(12.5)           // T = Double
}
