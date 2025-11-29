// Generic function that prints all items of any list type
fun <T> showList(list: List<T>) {
    for (element in list) {
        println(element)
    }
}

fun main() {
    val intList = listOf(1, 2, 3, 4)
    val stringList = listOf("Ali", "Sara", "Adam")
    val doubleList = listOf(1.5, 2.5, 3.5)

    showList(intList)     // Works with Int list
    showList(stringList)  // Works with String list
    showList(doubleList)  // Works with Double list
}
