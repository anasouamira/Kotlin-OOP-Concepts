// ===========================================================
// Example: Function Overriding (Runtime Polymorphism)
// ===========================================================

// Parent class
open class Shape {

    // 'open' allows this function to be overridden by subclasses
    open fun draw() {
        println("Drawing a generic shape")
    }

    open fun area(): Double {
        println("Calculating area of a generic shape")
        return 0.0
    }
}

// Child class 1
class Circle(private val radius: Double) : Shape() {

    // Override the parent's draw() method
    override fun draw() {
        println("Drawing a Circle with radius $radius")
    }

    // Override area() with Circle's formula
    override fun area(): Double {
        return Math.PI * radius * radius
    }
}

// Child class 2
class Rectangle(private val width: Double, private val height: Double) : Shape() {

    override fun draw() {
        println("Drawing a Rectangle with width $width and height $height")
    }

    override fun area(): Double {
        return width * height
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Parent reference pointing to child objects
    val shape1: Shape = Circle(5.0)
    val shape2: Shape = Rectangle(4.0, 6.0)

    // Runtime Polymorphism:
    // The function called depends on the actual object's type at runtime
    shape1.draw()  // Calls Circle's draw()
    println("Area = ${shape1.area()}")

    println("------------")

    shape2.draw()  // Calls Rectangle's draw()
    println("Area = ${shape2.area()}")

    println("------------")

    // Using a list of shapes to demonstrate polymorphic behavior
    val shapes: List<Shape> = listOf(Circle(3.0), Rectangle(2.0, 5.0))
    for (s in shapes) {
        s.draw()
        println("Area = ${s.area()}")
        println("------------")
    }
}
