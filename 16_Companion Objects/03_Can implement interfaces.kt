// Interface with required functions
interface ClickListener {
    fun onClick()
    fun onDoubleClick()
}

// Singleton object implementing the interface
object ButtonHandler : ClickListener {

    // Implementation of interface methods
    override fun onClick() {
        println("Button clicked once")
    }

    override fun onDoubleClick() {
        println("Button double-clicked")
    }

    // Additional custom method
    fun showStatus() {
        println("ButtonHandler is active")
    }
}

fun main() {
    // Calling methods on the Singleton implementing the interface
    ButtonHandler.showStatus()
    ButtonHandler.onClick()
    ButtonHandler.onDoubleClick()
}
