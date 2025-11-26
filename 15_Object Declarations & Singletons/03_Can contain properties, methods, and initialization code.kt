// Singleton object with properties, methods, and initialization code
object AppSettings {

    // Property (variable)
    var theme: String = "Light"

    // Read-only property (val)
    val version: String = "1.0.0"

    // Initialization block executed only once when object is first accessed
    init {
        println("AppSettings initialized") // printed only once
    }

    // Method to change the theme
    fun changeTheme(newTheme: String) {
        theme = newTheme
        println("Theme changed to: $theme")
    }

    // Method to display current settings
    fun showSettings() {
        println("Theme: $theme - Version: $version")
    }
}

// Example usage
fun main() {
    // First access -> triggers init block
    AppSettings.showSettings()

    // Change a property using method
    AppSettings.changeTheme("Dark")

    // Calling again does not run init block anymore
    AppSettings.showSettings()
}
