import java.util.*

/**This class allows to create an object Vehicle. This object receives parameters correspond to its plate, vehicle type, how long stayed and the discount card(in case its has)*/
data class Vehicle(
    val plate: String,
    val type: VehicleType,
    val checkInTime: Calendar,
    val discountCard: String? = null
) {
    //function states that two Vehicles are equals if their plates are equal
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    //function state that hashCode (used internally in search functions/in sets and arrays)
    // is the hashCode of the plate
    override fun hashCode(): Int = this.plate.hashCode()
}
