// Polymorphism_Project.kt
// Kotlin project demonstrating complex polymorphism concepts

// ===============================
// Base class
// ===============================
open class MediaItem(val title: String) {
    open fun play() {
        println("Playing media item: $title")
    }

    open fun info(): String {
        return "MediaItem(title=$title)"
    }

    // Function overloading (compile-time polymorphism)
    fun info(details: Boolean) {
        if (details) {
            println("Detailed info: MediaItem(title=$title)")
        } else {
            println(info())
        }
    }
}

// ===============================
// First Level Inheritance
// ===============================
open class Audio(title: String, val duration: Int) : MediaItem(title) {
    override fun play() {
        println("Playing audio: $title | Duration: $duration mins")
    }

    override fun info(): String {
        return "Audio(title=$title, duration=$duration mins)"
    }

    // Overloaded function
    fun play(volume: Int) {
        println("Playing $title at volume $volume")
    }
}

// ===============================
// Second Level Inheritance
// ===============================
class Song(title: String, duration: Int, val artist: String) : Audio(title, duration) {
    override fun play() {
        super.play() // call Audio play
        println("Now playing song by $artist")
    }

    override fun info(): String {
        return super.info() + " | Artist: $artist"
    }
}

// ===============================
// Another branch
// ===============================
class Video(title: String, val resolution: String) : MediaItem(title) {
    override fun play() {
        println("Playing video: $title at resolution $resolution")
    }

    override fun info(): String {
        return "Video(title=$title, resolution=$resolution)"
    }
}

// ===============================
// Main function demonstrating polymorphism
// ===============================
fun main() {
    println("===== Polymorphism Demonstration =====")

    // Compile-time polymorphism: function overloading
    val song1 = Song("Imagine", 5, "John Lennon")
    song1.play()            // runtime polymorphism
    song1.play(8)           // compile-time polymorphism (overloaded method)

    // Runtime polymorphism: function overriding
    val mediaList: List<MediaItem> = listOf(
        song1, 
        Video("Inception Trailer", "1080p"), 
        Audio("Podcast Episode 1", 60)
    )

    println("\n--- Playing all media items (dynamic dispatch) ---")
    for (item in mediaList) {
        item.play() // runtime polymorphism via open + override
    }

    println("\n--- Upcasting / Downcasting Demonstration ---")
    val media: MediaItem = song1 // upcasting
    println(media.info())

    if (media is Song) { // smart cast after checking type
        println("Casting successful: Artist is ${media.artist}")
        media.play() // overridden play() called
    }

    // Unsafe cast example (as)
    val audioMedia: Audio = media as Audio
    audioMedia.play(10) // compile-time overload works
}