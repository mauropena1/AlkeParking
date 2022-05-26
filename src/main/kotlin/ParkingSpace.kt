import java.util.*
import kotlin.math.ceil
import kotlin.math.roundToInt


data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    val MINUTES_IN_MILISECONDS =60000

    /**
     * Constant that store the total time that a vehicle stayed in the Parking Space in milliseconds
     */
    private val parkedTime: Long
        get() = ((Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS)


    fun checkOutVehicle(plate: String, type: VehicleType) {

        val vehicle = parking.vehicles.find { it.plate == plate }
        if (vehicle != null) {
            val parkedTimeInt = parkedTime.toInt()
            if (vehicle.discountCard != null) {
                onSuccess(calculateFee(type, parkedTimeInt, true))
            } else {
                onSuccess(calculateFee(type, parkedTimeInt, false))
            }
            parking.vehicles.remove(vehicle)
        } else {
            onError()
        }
    }


    private fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscountCard: Boolean): Int {
        if (parkedTime > 120) {
            val blocks = (parkedTime.toFloat() - 120) / 15
            val roundBlocks = (ceil(blocks)).toInt()
            val totalPrice = when (type) {
                VehicleType.CAR -> VehicleType.CAR.price + (roundBlocks * 5)
                VehicleType.MOTORCYCLE -> VehicleType.MOTORCYCLE.price + (roundBlocks * 5)
                VehicleType.BUS -> VehicleType.BUS.price + (roundBlocks * 5)
                VehicleType.MINI_BUS -> VehicleType.MINI_BUS.price + (roundBlocks * 5)
            }
            return if (hasDiscountCard) {
                (totalPrice * 0.85).roundToInt()
            } else {
                return totalPrice
            }
        } else {
            val totalPrice = when (type) {
                VehicleType.CAR -> VehicleType.CAR.price
                VehicleType.MOTORCYCLE -> VehicleType.MOTORCYCLE.price
                VehicleType.BUS -> VehicleType.BUS.price
                VehicleType.MINI_BUS -> VehicleType.MINI_BUS.price
            }
            return if (hasDiscountCard) {
                (totalPrice * 0.85).roundToInt()
            } else {
                return totalPrice
            }
        }
    }


    private fun onSuccess(totalAmount: Int) {
        incrementValues(totalAmount)
        parking.vehiclesRecord = Pair(parking.totalVehicles, parking.totalEarnings )
        println("Your fee is $totalAmount. Come back soon.")
    }

    private fun incrementValues(totalAmount: Int) {
        parking.apply {
            totalVehicles += 1
            totalEarnings += totalAmount
        }
    }


    private fun onError() {
        println("Sorry, the check-out failed")
    }
}
