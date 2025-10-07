// ======================================================
// Example: Defining a class in Kotlin (class + constructor)
// ======================================================

// 1️⃣ Define a class with a primary constructor
class Person(val name: String, var age: Int) {
    // 'val' means the property is read-only (cannot be reassigned)
    // 'var' means the property is mutable (can be changed)

    // init block runs right after the primary constructor
    init {
        println("A Person object is created for $name, age $age")
    }

    // Class function (method)
    fun introduce() {
        println("Hi, my name is $name and I am $age years old.")
    }
}


// 2️⃣ Define another class with a secondary constructor
class Car {
    var brand: String
    var year: Int

    // Secondary constructor — used to create objects in another way
    constructor(brand: String, year: Int) {
        this.brand = brand
        this.year = year
    }

    fun showInfo() {
        println("Car brand: $brand, year: $year")
    }
}


// 3️⃣ Class with both primary and secondary constructors
class Student(val name: String, var grade: Double) {

    // Secondary constructor that calls the primary one
    constructor(name: String) : this(name, 0.0) {
        println("Student $name created with default grade 0.0")
    }

    fun display() {
        println("Student name: $name, grade: $grade")
    }
}


// ======================================================
// MAIN FUNCTION — creating objects from these classes
// ======================================================
fun main() {
    // Create object using primary constructor
    val person1 = Person("Alice", 25)
    person1.introduce()

    // Create object using secondary constructor
    val car1 = Car("Toyota", 2020)
    car1.showInfo()

    // Create objects using both constructors
    val student1 = Student("Bob", 3.7)
    val student2 = Student("Lina") // uses secondary constructor
    student1.display()
    student2.display()
}
