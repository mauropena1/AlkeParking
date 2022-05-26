

data class Parking(val vehicles: MutableSet<Vehicle>, var maxVehicles: Int = 20) {
    var totalVehicles = 0
    var totalEarnings = 0
    var vehiclesRecord: Pair<Int, Int> = Pair(totalVehicles, totalEarnings)


    fun addVehicle(vehicle: Vehicle): Boolean {

        return if (maxVehicles > getCount()) {
            if(vehicles.add(vehicle)){
                println("Welcome to AlkeParking!")
                true
            }else{
                println("Sorry, the check-in failed, the vehicle is already parked.")
                false
            }
        } else {
            println("Sorry, the check-in failed, the parking lot is full.")
            false
        }
    }


    fun showEarnings(){
        println("${vehiclesRecord.first} vehicles have checked out and have earnings of $${vehiclesRecord.second}")
    }


    fun listVehicles(){
        val plateList= vehicles.toList().map { "[${it.plate}]" }
        println(plateList)
    }

    private fun getCount() : Int = vehicles.size
}
