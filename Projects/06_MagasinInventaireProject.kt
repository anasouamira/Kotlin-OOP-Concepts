// ======================= PRODUIT CLASS =======================
class Produit(
    val nom: String,                // Product name
    val idProduit: Int,             // Unique product ID
    var quantite: Int,              // Quantity available in stock
    val prix: Double                // Unit price
) {

    // Display product information
    fun afficherInfo() {
        println("ID: $idProduit | $nom | Quantité: $quantite | Prix: $prix DH")
    }

    // Increase product quantity (stock entry)
    fun ajouterQuantite(qte: Int) {
        quantite += qte
        println("$qte unités ajoutées au produit $nom. Nouvelle quantité: $quantite")
    }

    // Decrease product quantity (sell)
    fun retirerQuantite(qte: Int) {
        if (qte <= quantite) {
            quantite -= qte
            println("$qte unités retirées de $nom. Quantité restante: $quantite")
        } else {
            println("Stock insuffisant pour $nom ! Disponibilité: $quantite")
        }
    }
}

// ======================= MOUVEMENT STOCK CLASS =======================
class MouvementStock(
    val idMouvement: Int,               // Unique movement ID
    val produit: Produit,               // Related product
    val typeMouvement: String,          // "entrée" or "sortie"
    val quantite: Int,                  // Quantity moved
    val date: String                    // Movement date
) {

    // Display movement details
    fun afficherDetails() {
        println("----- Mouvement $idMouvement -----")
        println("Produit: ${produit.nom} | Type: $typeMouvement | Quantité: $quantite | Date: $date")
    }
}

// ======================= MAGASIN CLASS =======================
class Magasin {

    private val produits = mutableListOf<Produit>()               // Product list
    private val mouvements = mutableListOf<MouvementStock>()      // Movement list

    // Add product to inventory
    fun ajouterProduit(produit: Produit) {
        produits.add(produit)
        println("Produit ajouté avec succès.")
    }

    // Display all stock products
    fun afficherProduits() {
        println("======== STOCK ACTUEL ========")
        produits.forEach { it.afficherInfo() }
    }

    // Record stock entry
    fun enregistrerEntree(idProduit: Int, quantite: Int, date: String) {
        val produit = produits.find { it.idProduit == idProduit }

        if (produit != null) {
            produit.ajouterQuantite(quantite)
            val mouvement = MouvementStock(mouvements.size + 1, produit, "entrée", quantite, date)
            mouvements.add(mouvement)
        } else {
            println("Produit introuvable.")
        }
    }

    // Record stock exit (sale)
    fun enregistrerSortie(idProduit: Int, quantite: Int, date: String) {
        val produit = produits.find { it.idProduit == idProduit }

        if (produit != null) {
            if (quantite <= produit.quantite) {
                produit.retirerQuantite(quantite)
                val mouvement = MouvementStock(mouvements.size + 1, produit, "sortie", quantite, date)
                mouvements.add(mouvements.size, mouvement)
            } else {
                println("Sortie impossible : quantité insuffisante.")
            }
        } else {
            println("Produit introuvable.")
        }
    }

    // Display all stock movements
    fun afficherMouvements() {
        println("======== MOUVEMENTS DU STOCK ========")
        mouvements.forEach { it.afficherDetails() }
    }
}

// ======================= MAIN TEST =======================
fun main() {
    val magasin = Magasin()

    val p1 = Produit("Lait", 1, 50, 10.0)
    val p2 = Produit("Pain", 2, 30, 3.0)

    magasin.ajouterProduit(p1)
    magasin.ajouterProduit(p2)

    magasin.afficherProduits()

    magasin.enregistrerEntree(1, 20, "01-03-2025")
    magasin.enregistrerSortie(2, 10, "02-03-2025")

    magasin.afficherProduits()
    magasin.afficherMouvements()
}
