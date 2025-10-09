// SealedClasses_Project.kt
// Kotlin project demonstrating Sealed Classes and Interfaces

// ===============================
// Sealed class example
// ===============================
sealed class NetworkResult {
    data class Success(val data: String) : NetworkResult()
    data class Error(val errorMsg: String) : NetworkResult()
    object Loading : NetworkResult()
}

// Function to demonstrate exhaustive when expression
fun handleNetworkResult(result: NetworkResult) {
    when(result) {
        is NetworkResult.Success -> println("Data received: ${result.data}")
        is NetworkResult.Error -> println("Error occurred: ${result.errorMsg}")
        NetworkResult.Loading -> println("Loading data...")
    }
}

// ===============================
// Sealed interface example
// ===============================
sealed interface Shape {
    fun area(): Double
}

data class Circle(val radius: Double) : Shape {
    override fun area(): Double = 3.14 * radius * radius
}

data class Rectangle(val width: Double, val height: Double) : Shape {
    override fun area(): Double = width * height
}

fun handleShape(shape: Shape) {
    when(shape) {
        is Circle -> println("Circle area: ${shape.area()}")
        is Rectangle -> println("Rectangle area: ${shape.area()}")
        // No else needed due to sealed type
    }
}

// ===============================
// Main function
// ===============================
fun main() {
    println("--- Network Result Examples ---")
    val success = NetworkResult.Success("User data loaded")
    val error = NetworkResult.Error("404 Not Found")
    val loading = NetworkResult.Loading

    handleNetworkResult(success)
    handleNetworkResult(error)
    handleNetworkResult(loading)

    println("\n--- Shape Examples ---")
    val circle = Circle(5.0)
    val rectangle = Rectangle(4.0, 6.0)

    handleShape(circle)
    handleShape(rectangle)
}