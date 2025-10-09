// ===========================================================
// Advanced Example: Sealed Interfaces with Nested States
// ===========================================================

// Sealed interface for network operations
sealed interface NetworkState {

    // Nested subclasses representing all possible states
    data class Success(val data: String) : NetworkState
    data class Error(val code: Int, val message: String) : NetworkState
    object Loading : NetworkState
    object Idle : NetworkState
}

// Sealed interface for UI state derived from network
sealed interface UiState {
    data class ShowData(val data: String) : UiState
    data class ShowError(val message: String) : UiState
    object ShowLoading : UiState
    object ShowIdle : UiState
}

// Function to map network state to UI state
fun mapNetworkToUi(networkState: NetworkState): UiState {
    return when (networkState) {
        is NetworkState.Success -> UiState.ShowData(networkState.data)
        is NetworkState.Error -> UiState.ShowError(networkState.message)
        NetworkState.Loading -> UiState.ShowLoading
        NetworkState.Idle -> UiState.ShowIdle
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val states = listOf<NetworkState>(
        NetworkState.Idle,
        NetworkState.Loading,
        NetworkState.Success("User profile loaded"),
        NetworkState.Error(404, "Not Found")
    )

    for (state in states) {
        val ui = mapNetworkToUi(state)
        // Using 'when' to render UI based on UiState
        when (ui) {
            is UiState.ShowData -> println("UI: Displaying data -> ${ui.data}")
            is UiState.ShowError -> println("UI: Displaying error -> ${ui.message}")
            UiState.ShowLoading -> println("UI: Loading spinner shown")
            UiState.ShowIdle -> println("UI: Idle state, nothing to show")
        }
    }
}
