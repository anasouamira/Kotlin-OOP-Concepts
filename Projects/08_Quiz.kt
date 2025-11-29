// Interface definition that requires implementing classes to provide progress text and a progress bar function
interface ProgressPrintable {
    val progressText: String   // property that must be implemented
    fun printProgressBar()     // method that must be implemented
}

// Enum class representing levels of difficulty
enum class Difficulty {
    EASY, MEDIUM, HARD
}

// Generic Data Class representing a question that accepts any type T for the answer
data class Question<T>(
    val questionText: String,  // text of the question
    val answer: T,             // correct answer (any type)
    val difficulty: Difficulty // level of difficulty
)

// Main Quiz class implementing ProgressPrintable interface
class Quiz : ProgressPrintable {

    // Creating questions of different generic types
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    // Prints each question and its answer + difficulty
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    // Override required property from interface
    override val progressText: String
        get() = "$answered of $total answered"   // read-only computed property

    // Override required function from interface
    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }            // print filled progress bar blocks
        repeat(Quiz.total - Quiz.answered) { print("▒") } // print empty blocks
        println()
        println(progressText)                            // print formatted progress text
    }

    // Companion object acts like static container for shared values
    companion object StudentProgress {
        var total: Int = 10     // total number of questions
        var answered: Int = 3   // answered questions
    }
}

fun main() {
    // Create an instance of Quiz and print questions
    val quiz = Quiz().apply {
        printQuiz()
    }
}
