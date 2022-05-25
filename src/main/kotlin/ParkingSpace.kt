import java.util.*


data class ParkingSpace(var vehicle:Vehicle, val parking:Parking){
    val plate:String = vehicle.plate
    val checkInTime=vehicle.checkInTime
    val discountCard=vehicle.discountCard
    var parkedTime :Int=0


    fun checkOutVehicle( plate : String, type :VehicleType ) {
        try {
            val vehicle: Vehicle? = parking.vehicles.find { it.plate ==plate }

            var type : VehicleType = vehicle?.type?:VehicleType.CAR
            parkedTime= ((Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / 60000).toInt()

            onSuccess(calculateFee(type, parkedTime))
        }catch (e: ArithmeticException){
            onError(plate)
        }
    }

    fun calculateFee(type: VehicleType, time: Int) :Int{
        var totalAmount=0
        var base=type.price
        var extraTimeParked=time-120
        if(parkedTime>120){
            totalAmount=(extraTimeParked/15)*5+base
        }else{
            totalAmount= base
        }
        return totalAmount
    }

    fun onSuccess(totalAmount:Int){
        println("Your total invoice is $$totalAmount")
    }

    fun onError(plate:String){
        println("it wasn't possible checkout a car with plate $plate")
    }



}
