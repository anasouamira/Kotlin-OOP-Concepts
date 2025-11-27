// ======================== ETUDIANT CLASS ========================
class Etudiant(
    val nom: String,                         // Student name
    val idEtudiant: Int,                     // Unique student ID
    val coursInscrits: MutableList<Cours> = mutableListOf()   // List of enrolled courses
) {

    // Enroll student in a course
    fun inscrireCours(cours: Cours) {
        coursInscrits.add(cours)
        println("Étudiant $nom inscrit au cours ${cours.titre}")
    }

    // Display courses student is enrolled in
    fun afficherCours() {
        println("===== Cours inscrits de $nom =====")
        if (coursInscrits.isEmpty()) {
            println("Aucun cours inscrit.")
        } else {
            coursInscrits.forEach { println("${it.titre} (ID: ${it.idCours})") }
        }
    }
}

// ======================== COURS CLASS ========================
class Cours(
    val titre: String,                         // Course title
    val idCours: Int,                          // Unique course ID
    val enseignant: String,                    // Teacher name
    val etudiants: MutableList<Etudiant> = mutableListOf() // Enrolled students
) {

    // Add a student to course list
    fun ajouterEtudiant(etudiant: Etudiant) {
        etudiants.add(etudiant)
        println("Étudiant ${etudiant.nom} ajouté au cours $titre.")
    }

    // Display students in the course
    fun afficherEtudiants() {
        println("===== Étudiants inscrits au cours $titre =====")
        if (etudiants.isEmpty()) {
            println("Aucun étudiant inscrit.")
        } else {
            etudiants.forEach { println("${it.nom} (ID: ${it.idEtudiant})") }
        }
    }
}

// ======================== ECOLE CLASS ========================
class Ecole {

    private val etudiants = mutableListOf<Etudiant>()     // List of all students
    private val cours = mutableListOf<Cours>()            // List of all courses

    // Add a new student
    fun ajouterEtudiant(etudiant: Etudiant) {
        etudiants.add(etudiant)
        println("Étudiant ajouté avec succès.")
    }

    // Add a new course
    fun ajouterCours(cours: Cours) {
        this.cours.add(cours)
        println("Cours ajouté avec succès.")
    }

    // Enroll student in a course by their IDs
    fun inscrireEtudiantCours(idEtudiant: Int, idCours: Int) {
        val etu = etudiants.find { it.idEtudiant == idEtudiant }
        val cour = cours.find { it.idCours == idCours }

        if (etu != null && cour != null) {
            etu.inscrireCours(cour)
            cour.ajouterEtudiant(etu)
        } else {
            println("Erreur : Étudiant ou cours introuvable.")
        }
    }

    // Display all students
    fun afficherEtudiants() {
        println("===== Liste des étudiants =====")
        etudiants.forEach { println("${it.nom} (ID: ${it.idEtudiant})") }
    }

    // Display all courses
    fun afficherCours() {
        println("===== Liste des cours =====")
        cours.forEach { println("${it.titre} (ID: ${it.idCours}) | Enseignant: ${it.enseignant}") }
    }
}

// ======================== MAIN TEST ========================
fun main() {
    val ecole = Ecole()

    val et1 = Etudiant("Anas Ouamira", 1)
    val et2 = Etudiant("Yassine", 2)

    val c1 = Cours("Mathématiques", 101, "Prof. Ahmed")
    val c2 = Cours("Programmation Kotlin", 102, "Prof. Omar")

    ecole.ajouterEtudiant(et1)
    ecole.ajouterEtudiant(et2)
    ecole.ajouterCours(c1)
    ecole.ajouterCours(c2)

    ecole.afficherEtudiants()
    ecole.afficherCours()

    ecole.inscrireEtudiantCours(1, 102)
    ecole.inscrireEtudiantCours(2, 101)

    et1.afficherCours()
    c1.afficherEtudiants()
}
