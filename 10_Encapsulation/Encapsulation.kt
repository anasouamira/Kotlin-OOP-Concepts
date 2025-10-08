// ===========================================================
// Example: Encapsulation in Kotlin
// ===========================================================

class BankAccount(private var balance: Double) { // balance is private

    // Getter for balance (read-only access)
    fun getBalance(): Double {
        return balance
    }

    // Setter for balance (controlled modification)
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited $amount. New balance: $balance")
        } else {
            println("Invalid deposit amount!")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrew $amount. New balance: $balance")
        } else {
            println("Invalid withdrawal amount!")
        }
    }
}

// ===========================================================
// MAIN FUNCTION
// ===========================================================
fun main() {

    val account = BankAccount(1000.0)

    // ❌ Cannot access balance directly because it's private
    // println(account.balance) // Error

    // ✅ Accessing balance via getter
    println("Current balance: ${account.getBalance()}")

    // ✅ Controlled modifications
    account.deposit(500.0)
    account.withdraw(200.0)

    // ❌ Invalid operations are prevented
    account.deposit(-100.0)
    account.withdraw(2000.0)
}
