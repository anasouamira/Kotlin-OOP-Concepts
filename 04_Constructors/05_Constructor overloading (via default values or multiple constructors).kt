// ======================================================
// Complex Example: Constructor Overloading in Kotlin
// ======================================================

class Student(
    val name: String,           // main property
    var age: Int = 18,          // default value
    var grade: String = "N/A"   // default value
) {
    var scholarship: Boolean = false

    // init block runs after primary or secondary constructor
    init {
        println("Init block: Student created → Name: $name, Age: $age, Grade: $grade, Scholarship: $scholarship")
    }

    // ==================================================
    // 1️⃣ Secondary constructor — when only name is given
    // ==================================================
    constructor(name: String) : this(name, 18, "Unknown") {
        println("Secondary constructor (name only) called")
    }

    // ==================================================
    // 2️⃣ Secondary constructor — when name and grade are given
    // ==================================================
    constructor(name: String, grade: String) : this(name, 18, grade) {
        println("Secondary constructor (name + grade) called")
    }

    // ==================================================
    // 3️⃣ Secondary constructor — when student has scholarship
    // ==================================================
    constructor(name: String, age: Int, grade: String, hasScholarship: Boolean)
            : this(name, age, grade) {
        scholarship = hasScholarship
        println("Secondary constructor (full + scholarship) called")
    }

    // Function to show student info
    fun showInfo() {
        println("→ Student Info: $name | Age: $age | Grade: $grade | Scholarship: $scholarship")
    }
}


// ======================================================
// MAIN FUNCTION — testing constructor overloading
// ======================================================
fun main() {

    // 1️⃣ Using primary constructor with all arguments
    val s1 = Student("Alice", 20, "A+")
    s1.showInfo()

    println("------------------------------------------------")

    // 2️⃣ Using secondary constructor with only name
    val s2 = Student("Bob")
    s2.showInfo()

    println("------------------------------------------------")

    // 3️⃣ Using secondary constructor with name and grade
    val s3 = Student("Charlie", "B")
    s3.showInfo()

    println("------------------------------------------------")

    // 4️⃣ Using secondary constructor with scholarship
    val s4 = Student("Diana", 22, "A", true)
    s4.showInfo()
}
