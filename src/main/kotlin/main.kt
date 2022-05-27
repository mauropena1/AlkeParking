import java.util.*


val cars = mutableSetOf<Vehicle>()
val parking = Parking(cars)

fun main(args: Array<String>) {
    randomlyAddedVehicles(20)
    parking.listVehicles()
    randomlyCheckOut()
    randomlyCheckOut()
    randomlyCheckOut()
    randomlyCheckOut()
    parking.showEarnings()
}

/**Function that allows testing the code, generating and adding to the parking car different vehicles, in a randomly way*/
private fun randomlyAddedVehicles(totalVehicles: Int) {

    for (i in 1..totalVehicles) {

        var plateLetters = ""
        val plateNum = (100..999).random()

        (1..3).forEach { _ ->
            plateLetters += ('A'..'Z').random()
        }

        val type = when (i) {
            0, 4, 8, 12, 16 -> VehicleType.CAR
            1, 5, 9, 13, 17 -> VehicleType.MOTORCYCLE
            2, 6, 10, 14, 18 -> VehicleType.MINI_BUS
            3, 7, 11, 15, 19 -> VehicleType.BUS
            else -> VehicleType.CAR
        }
        val vehicle: Vehicle = if (i % 3 == 0) {
            val dCard = (0..2000).random()
            Vehicle("$plateLetters$plateNum", type, Calendar.getInstance(), "DC_$dCard")
        } else {
            Vehicle("$plateLetters$plateNum", type, Calendar.getInstance())
        }
        parking.addVehicle(vehicle)
    }
}

/**This function retires vehicles from the park, in a randomly way*/
private fun randomlyCheckOut() {
    val vehicleToRemove = parking.vehicles.random()
    val parkingSpace = ParkingSpace(vehicleToRemove, parking)
    parkingSpace.checkOutVehicle(vehicleToRemove.plate, vehicleToRemove.type)
}
