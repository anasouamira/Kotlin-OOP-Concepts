// Generic class using T as a placeholder for any type
class Holder<T>(private val item: T) {

    fun getItem(): T {
        return item
    }
}

fun main() {
    val h1 = Holder(10)          // T = Int
    val h2 = Holder("Kotlin")    // T = String

    println(h1.getItem())
    println(h2.getItem())
}
