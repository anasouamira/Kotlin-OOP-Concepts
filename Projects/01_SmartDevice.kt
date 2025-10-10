// Detailed explanation comments (in English) are placed inline as requested.
// After this code block I'll write a full, structured explanation in Arabic
// that walks you through every concept used in this file.

/*
  High-level overview in one sentence:
  - This file models a small smart-home domain: a base SmartDevice class, two concrete devices
    (Smart TV and Smart Light), a SmartHome controller that manipulates them, and a
    RangeRegulator property delegate used to enforce numeric ranges for device settings.
*/

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// -------------------------------------------------------------
// Base class: SmartDevice
// -------------------------------------------------------------
open class SmartDevice(
    // Primary constructor parameters. Declaring them with `val` creates read-only properties.
    val name: String,
    val category: String
) {

    // `deviceStatus` is a mutable property initialized to "online".
    // Kotlin auto-generates getter and setter for `var` properties.
    // `protected set` means: anyone can read `deviceStatus`, but only this class and its subclasses
    // can assign to it (cannot be changed from outside instances).
    var deviceStatus = "online"
        protected set

    // `open` allows subclasses to override this property.
    // `val` means read-only (no setter is generated).
    open val deviceType = "unknown"

    // An `open` function so subclasses can override the behavior.
    open fun turnOn() {
        // modify the protected setter of deviceStatus (allowed in the class)
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }
}

// -------------------------------------------------------------
// Subclass: SmartTvDevice
// -------------------------------------------------------------
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    // Call the superclass constructor passing named params.
    SmartDevice(name = deviceName, category = deviceCategory) {

    // Override the deviceType to give a more specific value.
    override val deviceType = "Smart TV"

    /*
      Property delegation:
      - `by RangeRegulator(...)` means the get/set of `speakerVolume` are delegated to the
        RangeRegulator object. Whenever Kotlin needs to read or write `speakerVolume`, it calls
        the delegate's getValue / setValue methods.
      - The delegate instance is created here (one RangeRegulator instance per property).
      - `private` restricts visibility so only this class can access the property directly.
    */
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    // Another delegated property for the current TV channel.
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    // Increase volume by one using the ++ operator. That operator uses getValue and setValue
    // under the hood (read current value, add 1, then write back).
    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    // Move to next channel similarly — property delegation handles storage and validation.
    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }

    // Override turnOn to add device-specific behavior, but call `super.turnOn()` first
    // so the base class can set common state (e.g., deviceStatus = "on").
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

// -------------------------------------------------------------
// Subclass: SmartLightDevice
// -------------------------------------------------------------
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    // brightnessLevel uses the same RangeRegulator delegate to constrain values between 0 and 100.
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

    override fun turnOn() {
        super.turnOn()
        // When turning on the light, we set a default brightness.
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        // When turning off, reset brightness to 0 (domain-specific behavior).
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// -------------------------------------------------------------
// Aggregator / Controller: SmartHome
// -------------------------------------------------------------
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {

    // Counts how many devices have been turned on (simple counter).
    // `private set` means outside code can read the count, but only SmartHome's methods modify it.
    var deviceTurnOnCount = 0
        private set

    // The methods below update the counter and delegate to device-specific behaviors.
    fun turnOnTv() {
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }

    fun turnOffTv() {
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    // Convenience: turn off both devices (note this calls the above methods,
    // which also modify the `deviceTurnOnCount`).
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

// -------------------------------------------------------------
// Property delegate class: RangeRegulator
// -------------------------------------------------------------
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    // Backing storage for the delegated property.
    // (It would be conventional to mark this `private` to restrict direct access.)
    var fieldData = initialValue

    // Called when the delegated property is read.
    // - thisRef: the object that owns the property (can be null for top-level or local delegates)
    // - property: reflection metadata (name, return type, etc.)
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    // Called when the delegated property is assigned to.
    // We enforce the allowed range here; values outside the range are ignored.
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
        // If the value is outside the range, we silently ignore it. Alternatives:
        // - clamp the value to the nearest bound,
        // - throw an IllegalArgumentException,
        // - log a warning, etc.
    }
}

// -------------------------------------------------------------
// Entry point: main
// -------------------------------------------------------------
fun main() {
    // Polymorphism example: the variable type is SmartDevice but the actual object is SmartTvDevice.
    // At runtime, overridden methods from SmartTvDevice will execute.
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    // Reassign `smartDevice` to a different concrete device:
    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}
