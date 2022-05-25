import java.util.*


data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {

    fun checkOutVehicle(plate: String, type: VehicleType) {
        val vehicle = parking.vehicles.find { it.plate == plate }
        if (vehicle != null) {
            val parkedTimeInt = parkedTime.toInt()
            onSuccess(calculateFee(type, parkedTimeInt))
            parking.vehicles.remove(vehicle)
        } else {
            onError(plate)
        }
    }

    fun calculateFee(type: VehicleType, time: Int): Int {
        var totalAmount = 0
        val base = type.price
        val extraTimeParked = time - 120
        totalAmount = if (time > 120) {
            (extraTimeParked / 15) * 5 + base
        } else {
            base
        }
        return totalAmount
    }

    fun onSuccess(totalAmount: Int) {
        println("Your total invoice is $$totalAmount")
    }

    fun onError(plate: String) {
        println("it wasn't possible checkout a car with plate $plate")
    }

    //Constant that store the total time that a vehicle stayed in the Parking Space in milliseconds
    val parkedTime: Long
        get() = ((Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / 60000)
}
