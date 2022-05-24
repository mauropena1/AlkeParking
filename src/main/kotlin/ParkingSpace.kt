import java.util.*

data class ParkingSpace(var vehicle:Vehicle){
    val plate:String = vehicle.plate
    val checkInTime:Long=0
    val discountCard:String=""
    val parkedTime:Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS

}
