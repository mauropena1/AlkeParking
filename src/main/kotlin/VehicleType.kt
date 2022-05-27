/**
 * This class contains the types of vehicles that are allowed to park and its corresponding base price for parking*/
enum class VehicleType(val price: Int) {
    MOTORCYCLE(15), CAR(20), MINI_BUS(25), BUS(30)
}