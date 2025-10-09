// ===========================================================
// Example: Use Cases for Data Classes in Kotlin
// ===========================================================

// 1️⃣ DTO (Data Transfer Object)
data class UserDTO(
    val id: Int,
    val name: String,
    val email: String
)

// 2️⃣ Entity (representing database table)
data class ProductEntity(
    val productId: Int,
    val name: String,
    val price: Double
)

// 3️⃣ Model (application model for business logic)
data class OrderModel(
    val orderId: Int,
    val product: ProductEntity,
    val quantity: Int
)

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    // Example: DTO
    val user = UserDTO(1, "Alice", "alice@example.com")
    println("User DTO: $user")

    // Example: Entity
    val product = ProductEntity(101, "Laptop", 1200.0)
    println("Product Entity: $product")

    // Example: Model
    val order = OrderModel(5001, product, 2)
    println("Order Model: $order")

    // Demonstrating copy() for updates
    val updatedOrder = order.copy(quantity = 3)
    println("Updated Order: $updatedOrder")

    // Destructuring
    val (orderId, prod, qty) = updatedOrder
    println("Destructured Order -> orderId=$orderId, product=${prod.name}, quantity=$qty")
}
