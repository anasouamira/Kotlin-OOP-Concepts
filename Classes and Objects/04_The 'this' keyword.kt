// ======================================================
// Example: The 'this' keyword in Kotlin
// ======================================================

class Student(val name: String, var grade: Double) {

    // Function that uses 'this' to refer to the current object
    fun showInfo() {
        // 'this.name' and 'this.grade' refer to the properties
        // of the current object (the one calling the function)
        println("Student name: ${this.name}, Grade: ${this.grade}")
    }

    // Function that has parameters with the same name as properties
    fun updateGrade(grade: Double) {
        // Here 'grade' (parameter) hides the property 'grade'
        // So we use 'this.grade' to refer to the class property
        this.grade = grade
    }

    // Function to compare the current object with another
    fun hasHigherGradeThan(other: Student): Boolean {
        // 'this.grade' refers to the current object's grade
        // 'other.grade' refers to the grade of another Student
        return this.grade > other.grade
    }
}


// ======================================================
// MAIN FUNCTION — testing 'this' keyword
// ======================================================
fun main() {
    val student1 = Student("Alice", 15.5)
    val student2 = Student("Bob", 12.0)

    student1.showInfo()
    student2.showInfo()

    // Update Bob's grade using 'this'
    student2.updateGrade(16.0)

    println("\nAfter updating Bob's grade:")
    student2.showInfo()

    // Compare grades using 'this'
    if (student2.hasHigherGradeThan(student1)) {
        println("${student2.name} has a higher grade than ${student1.name}")
    } else {
        println("${student1.name} has a higher grade than ${student2.name}")
    }
}
