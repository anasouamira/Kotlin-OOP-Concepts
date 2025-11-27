// ======================= LIVRE CLASS =======================
class Livre(
    val titre: String,              // Book title
    val auteur: String,             // Book author
    val idLivre: Int,               // Unique ID for the book
    var disponible: Boolean = true  // Indicates if book is available
) {

    // Borrow the book if available
    fun emprunter() {
        if (disponible) {
            disponible = false
            println("Le livre \"$titre\" a été emprunté.")
        } else {
            println("Le livre \"$titre\" n'est pas disponible.")
        }
    }

    // Return the book (make it available again)
    fun retourner() {
        disponible = true
        println("Le livre \"$titre\" a été retourné.")
    }

    // Display book information
    fun afficherInfo() {
        println("ID: $idLivre | $titre - $auteur | Disponible: $disponible")
    }
}

// ======================= UTILISATEUR CLASS =======================
class Utilisateur(
    val nom: String,                       // User name
    val idUtilisateur: Int,                // Unique user ID
    val livresEmpruntes: MutableList<Livre> = mutableListOf() // List of borrowed books
) {

    // Add a borrowed book to user's list
    fun ajouterLivreEmprunte(livre: Livre) {
        livresEmpruntes.add(livre)
    }

    // Remove a returned book from the user's list
    fun retirerLivreEmprunte(livre: Livre) {
        livresEmpruntes.remove(livre)
    }

    // Display all borrowed books
    fun afficherEmprunts() {
        println("==== Livres empruntés par $nom ====")
        if (livresEmpruntes.isEmpty()) {
            println("Aucun emprunt.")
        } else {
            livresEmpruntes.forEach { it.afficherInfo() }
        }
    }
}

// ======================= BIBLIOTHEQUE CLASS =======================
class Bibliotheque {

    private val livres = mutableListOf<Livre>()            // List of books in library
    private val utilisateurs = mutableListOf<Utilisateur>() // List of library users

    // Add book to library
    fun ajouterLivre(livre: Livre) {
        livres.add(livre)
        println("Livre ajouté avec succès.")
    }

    // Remove book by ID
    fun supprimerLivre(idLivre: Int) {
        val livre = livres.find { it.idLivre == idLivre }
        if (livre != null) {
            livres.remove(livre)
            println("Livre supprimé avec succès.")
        } else {
            println("Livre introuvable.")
        }
    }

    // Search a book by title
    fun rechercherLivre(titre: String) {
        val trouvé = livres.filter { it.titre.contains(titre, ignoreCase = true) }
        println("==== Résultats de recherche pour \"$titre\" ====")
        if (trouvé.isEmpty()) println("Aucun livre trouvé.")
        trouvé.forEach { it.afficherInfo() }
    }

    // Display all books
    fun afficherLivres() {
        println("==== Tous les livres dans la bibliothèque ====")
        livres.forEach { it.afficherInfo() }
    }

    // Borrow a book
    fun emprunterLivre(idLivre: Int, utilisateur: Utilisateur) {
        val livre = livres.find { it.idLivre == idLivre }

        if (livre != null && livre.disponible) {
            livre.emprunter()
            utilisateur.ajouterLivreEmprunte(livre)
        } else {
            println("Emprunt impossible (livre indisponible ou introuvable).")
        }
    }

    // Return a borrowed book
    fun retournerLivre(idLivre: Int, utilisateur: Utilisateur) {
        val livre = utilisateur.livresEmpruntes.find { it.idLivre == idLivre }

        if (livre != null) {
            livre.retourner()
            utilisateur.retirerLivreEmprunte(livre)
        } else {
            println("Ce livre n'est pas emprunté par cet utilisateur.")
        }
    }

    // Add user to library system
    fun ajouterUtilisateur(utilisateur: Utilisateur) {
        utilisateurs.add(utilisateur)
        println("Utilisateur ajouté avec succès.")
    }
}

// ======================= MAIN TEST =======================
fun main() {
    val biblio = Bibliotheque()

    val l1 = Livre("Les Misérables", "Victor Hugo", 1)
    val l2 = Livre("1984", "George Orwell", 2)

    val user1 = Utilisateur("Anas Ouamira", 100)

    biblio.ajouterLivre(l1)
    biblio.ajouterLivre(l2)
    biblio.ajouterUtilisateur(user1)

    biblio.afficherLivres()

    biblio.emprunterLivre(1, user1)
    user1.afficherEmprunts()

    biblio.retournerLivre(1, user1)
    user1.afficherEmprunts()

    biblio.rechercherLivre("1984")
}
