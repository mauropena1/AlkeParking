/**
 *This class represents the parking of the program, which allows 20 cars max, and also store the list of vehicles parked
 */
data class Parking(val vehicles: MutableSet<Vehicle>, var maxVehicles: Int = 20) {
    var totalVehicles = 0
    var totalEarnings = 0

    /**
     * variable that store the total parked cars and the profits generated*/
    var vehiclesRecord: Pair<Int, Int> = Pair(totalVehicles, totalEarnings)


    /**Function that has a vehicle as parameter and return true if there is space at the parking, since is 20 the top of parking cars allowed */
    fun addVehicle(vehicle: Vehicle): Boolean {

        return if (maxVehicles > getCount()) {
            if (vehicles.add(vehicle)) {
                println("Welcome to AlkeParking!")
                true
            } else {
                println("Sorry, the check-in failed, the vehicle is already parked.")
                false
            }
        } else {
            println("Sorry, the check-in failed, the parking lot is full.")
            false
        }
    }

    /**Function that shows the retired cars amount, and the profit generated*/
    fun showEarnings() {
        println("${vehiclesRecord.first} vehicles have checked out and have earnings of $${vehiclesRecord.second}")
    }

    /**This function shows the parked car's plates */
    fun listVehicles() {
        val plateList = vehicles.toList().map { "[${it.plate}]" }
        println("Parked Vehicles : $plateList")
    }

    /**Function that store the amount of cars that are parking at the moment that a car is getting into the park*/
    private fun getCount(): Int = vehicles.size
}
