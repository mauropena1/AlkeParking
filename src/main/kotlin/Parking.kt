import java.util.*

data class Parking(val vehicles: MutableSet<Vehicle>, var maxVehicles: Int = 20) {

    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (!vehicles.contains(vehicle)) {
            if (maxVehicles > vehicles.count()) {
                vehicles.add(vehicle)
                println("Welcome to AlkeParking!")
                true
            } else {
                println("Sorry, the check-in failed, the parking lot is full.")
                false
            }
        } else {
            println("Sorry, the check-in failed, the vehicle is already parked.")
            false
        }
    }
}
