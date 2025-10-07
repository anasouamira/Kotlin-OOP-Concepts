// ==========================================================
// Example: Accessing static-like members through class name
// ==========================================================

// A utility class to demonstrate static-like access
class TemperatureConverter {

    // 'companion object' is used to hold static-like members
    companion object {

        // Constant property (acts like static final in Java)
        const val CELSIUS_TO_FAHRENHEIT_RATIO = 9.0 / 5.0

        // Static-like method for conversion
        fun toFahrenheit(celsius: Double): Double {
            return celsius * CELSIUS_TO_FAHRENHEIT_RATIO + 32
        }

        // Another static-like method
        fun toCelsius(fahrenheit: Double): Double {
            return (fahrenheit - 32) / CELSIUS_TO_FAHRENHEIT_RATIO
        }
    }
}


// ==========================================================
// MAIN FUNCTION
// ==========================================================
fun main() {

    // ✅ Accessing the members directly through the class name
    println("25°C = ${TemperatureConverter.toFahrenheit(25.0)}°F")
    println("77°F = ${TemperatureConverter.toCelsius(77.0)}°C")

    // ✅ Accessing the constant property directly
    println("Conversion ratio: ${TemperatureConverter.CELSIUS_TO_FAHRENHEIT_RATIO}")

    // ❌ No need to create an instance:
    // val converter = TemperatureConverter()
    // converter.toFahrenheit(25.0) // Not needed
}
