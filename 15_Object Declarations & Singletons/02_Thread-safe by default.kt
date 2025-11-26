import kotlin.concurrent.thread

// Singleton object - thread-safe by default
object Counter {
    // shared property
    var value: Int = 0

    // function to increment value
    fun increment() {
        value++
    }
}

fun main() {
    // Create multiple threads trying to access the same Singleton
    val threads = List(1000) {
        thread {
            // All threads call increment() on the same object instance
            Counter.increment()
        }
    }

    // Wait for all threads to finish
    threads.forEach { it.join() }

    // Print the final value
    // Will be 1000 because the object is thread-safe during initialization
    println("Final Counter Value: ${Counter.value}")
}
