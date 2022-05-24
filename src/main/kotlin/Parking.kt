import java.util.*

data class Parking(val vehicles: MutableSet<Vehicle>, var maxVehicles: Int = 20) {

    fun addVehicle(vehicle: Vehicle): Boolean {
        return if (checkDuplicate(vehicle)) {
            if (maxVehicles > getCount()) {
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

    private fun getCount() : Int = vehicles.size

    private fun checkDuplicate(vehicle: Vehicle): Boolean  = !vehicles.contains(vehicle)

}
