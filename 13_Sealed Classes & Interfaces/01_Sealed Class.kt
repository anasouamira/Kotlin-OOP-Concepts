// ===========================================================
// Example: Sealed Class in Kotlin
// ===========================================================

// Sealed class representing a Result of an operation
sealed class OperationResult {

    // Subclass for success
    data class Success(val data: String) : OperationResult()

    // Subclass for failure
    data class Failure(val error: String) : OperationResult()

    // Subclass for loading state
    object Loading : OperationResult()
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Example results
    val result1: OperationResult = OperationResult.Success("Data loaded")
    val result2: OperationResult = OperationResult.Failure("Network error")
    val result3: OperationResult = OperationResult.Loading

    // Using 'when' for exhaustive checking
    fun handleResult(result: OperationResult) {
        when (result) {
            is OperationResult.Success -> println("Success: ${result.data}")
            is OperationResult.Failure -> println("Failure: ${result.error}")
            OperationResult.Loading -> println("Loading...")
            // No 'else' needed because all subclasses are known
        }
    }

    handleResult(result1)
    handleResult(result2)
    handleResult(result3)
}
