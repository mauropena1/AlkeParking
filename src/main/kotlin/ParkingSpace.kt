import java.util.*
import kotlin.math.ceil
import kotlin.math.roundToInt


data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    /**
     * Constant that represent the miliseconds amount in one minute*/
    val MINUTES_IN_MILISECONDS = 60000

    /**
     * Constant that store the total time that a vehicle stayed in the Parking Space in milliseconds*/
    private val parkedTime: Long
        get() = ((Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS)

    /**Function that first of all, check if the car which plate received as parameter is parked. In case it is parked,
     *  calculates the parked time and the amount to pay, according if it has a discount card. And the car is removed from the parked cars list
     * In case the car is not parked, shows a error message  */
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

    /**Function that calculates the final amount to pay, according the vehicle type, time parked, base fee and the discount card holding*/
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

    /**Function that shows the total amount to pay*/
    private fun onSuccess(totalAmount: Int) {
        incrementValues(totalAmount)
        parking.vehiclesRecord = Pair(parking.totalVehicles, parking.totalEarnings)
        println("Your fee is $totalAmount. Come back soon.")
    }

    /**With this function, it is setted a records of parked cars and the profit generated at that moment */
    private fun incrementValues(totalAmount: Int) {
        parking.apply {
            totalVehicles += 1
            totalEarnings += totalAmount
        }
    }

    /**Function that shows a check out failed message*/
    private fun onError() {
        println("Sorry, the check-out failed")
    }
}
