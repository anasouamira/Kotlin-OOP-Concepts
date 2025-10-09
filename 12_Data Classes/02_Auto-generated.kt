// ===========================================================
// Example: Auto-generated functions in Kotlin Data Classes
// ===========================================================

// Data class for a Student
data class Student(
    val name: String,
    val age: Int,
    val grade: String
)

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val student1 = Student("Alice", 20, "A")
    val student2 = Student("Alice", 20, "A")
    val student3 = Student("Bob", 21, "B")

    // =======================================================
    // 🔹 equals() - structural equality
    // =======================================================
    println("student1 == student2? ${student1 == student2}") // true
    println("student1 == student3? ${student1 == student3}") // false

    // =======================================================
    // 🔹 hashCode() - based on properties
    // =======================================================
    println("student1 hashCode: ${student1.hashCode()}")
    println("student2 hashCode: ${student2.hashCode()}")
    println("student3 hashCode: ${student3.hashCode()}")

    // =======================================================
    // 🔹 toString() - readable representation
    // =======================================================
    println(student1.toString())
    println(student3.toString())

    // =======================================================
    // 🔹 copy() - create a modified copy
    // =======================================================
    val updatedStudent = student1.copy(grade = "A+")
    println("Updated student: $updatedStudent")

    // =======================================================
    // 🔹 componentN() - destructuring
    // =======================================================
    val (name, age, grade) = student3
    println("Destructured: Name=$name, Age=$age, Grade=$grade")
}
