// ======================== ARTICLE CLASS ========================
class Article(
    val nom: String,            // Name of the item (ex: Pizza, Burger)
    val prix: Double,           // Price of the item
    val idArticle: Int          // Unique identifier for each item
) {
    // Display article information
    fun afficherInfo() {
        println("ID: $idArticle | $nom | Prix: $prix DH")
    }
}

// ======================== COMMANDE CLASS ========================
class Commande(
    val idCommande: Int,                      // Unique ID for each order
    val client: String,                       // Client name
    val articles: MutableList<Article> = mutableListOf(),  // Ordered items
    var statut: String = "en préparation"     // Status: en préparation, prêt, servi
) {

    // Add an article to the order
    fun ajouterArticle(article: Article) {
        articles.add(article)
        println("${article.nom} ajouté à la commande.")
    }

    // Change the status of the order
    fun changerStatut(nouveauStatut: String) {
        statut = nouveauStatut
        println("Statut de la commande $idCommande changé à : $statut")
    }

    // Display order details
    fun afficherCommande() {
        println("===== Commande ID: $idCommande =====")
        println("Client: $client")
        println("Statut: $statut")
        println("Articles commandés:")
        articles.forEach { it.afficherInfo() }
        println("=====================================")
    }
}

// ======================== RESTAURANT CLASS ========================
class Restaurant {

    private val menu = mutableListOf<Article>()        // Restaurant menu
    private val commandes = mutableListOf<Commande>()  // List of orders

    // Add a new item to the menu
    fun ajouterArticleMenu(article: Article) {
        menu.add(article)
        println("Article ajouté au menu.")
    }

    // Display the menu
    fun afficherMenu() {
        println("========= MENU DU RESTAURANT =========")
        menu.forEach { it.afficherInfo() }
        println("======================================")
    }

    // Create a new order
    fun prendreCommande(client: String, idsArticles: List<Int>) {
        val commande = Commande(commandes.size + 1, client)

        idsArticles.forEach { id ->
            val article = menu.find { it.idArticle == id }
            if (article != null) {
                commande.ajouterArticle(article)
            } else {
                println("Article avec ID $id introuvable.")
            }
        }

        commandes.add(commande)
        println("Commande créée avec succès.")
    }

    // Display all orders
    fun afficherCommandes() {
        println("========= LISTE DES COMMANDES =========")
        commandes.forEach { it.afficherCommande() }
    }

    // Display one specific order
    fun afficherCommande(idCommande: Int) {
        val commande = commandes.find { it.idCommande == idCommande }
        if (commande != null) {
            commande.afficherCommande()
        } else {
            println("Commande introuvable.")
        }
    }

    // Change status of an order
    fun changerStatutCommande(idCommande: Int, nouveauStatut: String) {
        val commande = commandes.find { it.idCommande == idCommande }
        if (commande != null) {
            commande.changerStatut(nouveauStatut)
        } else {
            println("Commande introuvable.")
        }
    }
}

// ======================== MAIN TEST ========================
fun main() {
    val resto = Restaurant()

    // Create menu items
    val a1 = Article("Pizza Margherita", 45.0, 1)
    val a2 = Article("Burger Cheese", 35.0, 2)
    val a3 = Article("Spaghetti", 40.0, 3)

    // Add menu items
    resto.ajouterArticleMenu(a1)
    resto.ajouterArticleMenu(a2)
    resto.ajouterArticleMenu(a3)

    resto.afficherMenu()

    // Create an order
    resto.prendreCommande("Anas", listOf(1, 3))
    resto.afficherCommandes()

    // Change status
    resto.changerStatutCommande(1, "prêt")
    resto.afficherCommande(1)

    resto.changerStatutCommande(1, "servi")
    resto.afficherCommandes()
}
