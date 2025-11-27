// ====================== VEHICULE CLASS ======================
class Vehicule(
    val marque: String,          // Brand of the vehicle
    val modele: String,          // Model of the vehicle
    val idVehicule: Int,         // Unique ID for each vehicle
    var disponible: Boolean = true  // Availability status
) {

    // Mark the vehicle as unavailable when reserved
    fun marquerIndisponible() {
        disponible = false
    }

    // Mark the vehicle as available when returned
    fun marquerDisponible() {
        disponible = true
    }

    // Display vehicle information
    fun afficherInfo() {
        println("ID: $idVehicule | $marque $modele | Disponible: $disponible")
    }
}

// ====================== RESERVATION CLASS ======================
class Reservation(
    val idReservation: Int,      // Unique reservation ID
    val vehicule: Vehicule,      // Vehicle reserved
    val client: String,          // Client name
    val dateDebut: String,       // Start date
    val dateFin: String          // End date
) {
    // Display reservation details
    fun afficherDetails() {
        println("Reservation ID: $idReservation")
        println("Client: $client | From $dateDebut to $dateFin")
        vehicule.afficherInfo()
    }
}

// ====================== PARC VEHICULES CLASS ======================
class ParcVehicules {

    private val vehicules = mutableListOf<Vehicule>()           // List of vehicles
    private val reservations = mutableListOf<Reservation>()     // List of reservations

    // Add vehicle to the list
    fun ajouterVehicule(vehicule: Vehicule) {
        vehicules.add(vehicule)
        println("Vehicule ajouté avec succès!")
    }

    // Display all available vehicles
    fun afficherVehiculesDisponibles() {
        println("==== Véhicules Disponibles ====")
        vehicules.filter { it.disponible }.forEach { it.afficherInfo() }
    }

    // Reserve a vehicle
    fun reserverVehicule(idVehicule: Int, client: String, dateDebut: String, dateFin: String) {
        val vehiculeTrouve = vehicules.find { it.idVehicule == idVehicule && it.disponible }

        if (vehiculeTrouve != null) {
            vehiculeTrouve.marquerIndisponible()
            val reservation = Reservation(reservations.size + 1, vehiculeTrouve, client, dateDebut, dateFin)
            reservations.add(reservation)
            println("Reservation effectuée avec succès!")
        } else {
            println("Véhicule non disponible ou introuvable.")
        }
    }

    // Return vehicle
    fun retournerVehicule(idVehicule: Int) {
        val vehiculeTrouve = vehicules.find { it.idVehicule == idVehicule }

        if (vehiculeTrouve != null) {
            vehiculeTrouve.marquerDisponible()
            println("Véhicule $idVehicule retourné avec succès!")
        }
    }

    // Display all reservations
    fun afficherReservations() {
        println("===== Reservations =====")
        reservations.forEach { it.afficherDetails() }
    }
}

// ====================== MAIN FOR TESTING ======================
fun main() {
    val parc = ParcVehicules()

    val v1 = Vehicule("Toyota", "Corolla", 1)
    val v2 = Vehicule("BMW", "X5", 2)

    parc.ajouterVehicule(v1)
    parc.ajouterVehicule(v2)

    parc.afficherVehiculesDisponibles()

    parc.reserverVehicule(1, "Anas", "01-03-2025", "05-03-2025")
    parc.afficherReservations()
    parc.afficherVehiculesDisponibles()

    parc.retournerVehicule(1)
    parc.afficherVehiculesDisponibles()
}
