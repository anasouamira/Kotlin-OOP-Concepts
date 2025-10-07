// ======================================================
// Example: protected modifier in Kotlin
// ======================================================

// Base class
open class Person {

    // Protected property – accessible in this class and subclasses
    protected var age: Int = 25

    // Protected function – accessible in this class and subclasses
    protected fun showAge() {
        println("Age: $age")
    }

    // Public function – can access protected members inside the class
    fun introduce() {
        println("Hi, I am a person.")
        showAge()
    }
}

// Subclass
class Student : Person() {

    fun studentInfo() {
        // Can access protected members from base class
        age = 18
        println("Student age is $age")
        showAge()
    }
}


// ======================================================
// MAIN FUNCTION — testing protected access
// ======================================================
fun main() {
    val student1 = Student()

    // Can access public function
    student1.introduce()

    // Can access public function in subclass
    student1.studentInfo()

    // The following lines would cause errors:
    // student1.age      ❌ cannot access protected property directly
    // student1.showAge()❌ cannot call protected function directly
}
