import java.util.*


data class ParkingSpace(var vehicle:Vehicle){
    val plate:String = vehicle.plate
    val checkInTime=vehicle.checkInTime
    val discountCard=vehicle.discountCard
    val parkedTime:Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / 60000

}
