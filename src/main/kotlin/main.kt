import java.util.*

fun main(args: Array<String>) {
    val car1 =Vehicle("CGHH-10", VehicleType.CAR, Calendar.getInstance(), "CARD1")
    val copycar1 =Vehicle("CGHH-10", VehicleType.CAR, Calendar.getInstance(), "CARD1")
    val car3 =Vehicle("MMDD-12", VehicleType.CAR, Calendar.getInstance(), "CARD1")
    val car4 =Vehicle("CGHH-13", VehicleType.CAR, Calendar.getInstance(), null)
    val car5 =Vehicle("CGHH-14", VehicleType.CAR, Calendar.getInstance(), null)
    val car6 =Vehicle("MMDD-15", VehicleType.CAR, Calendar.getInstance(), null)
    val moto1 =Vehicle("CGHH-16", VehicleType.MOTORCYCLE, Calendar.getInstance(), "CARD1")
    val moto2 =Vehicle("CGHH-17", VehicleType.MOTORCYCLE, Calendar.getInstance(), "CARD29")
    val moto3 =Vehicle("MMDD-18", VehicleType.MOTORCYCLE, Calendar.getInstance(), null)
    val moto4 =Vehicle("CGHH-19", VehicleType.MOTORCYCLE, Calendar.getInstance(), null)
    val moto5 =Vehicle("MMDD-20", VehicleType.MOTORCYCLE, Calendar.getInstance(), "CARD1")
    val minibus1 =Vehicle("CGHH-31", VehicleType.MINI_BUS, Calendar.getInstance(), "CARD1")
    val minibus2 =Vehicle("CGHH-32", VehicleType.MINI_BUS, Calendar.getInstance(), "CARD29")
    val minibus3 =Vehicle("MMDD-33", VehicleType.MINI_BUS, Calendar.getInstance(), "CARD1")
    val bus1 =Vehicle("CGHH-34", VehicleType.BUS, Calendar.getInstance(), "CARD1")
    val bus2 =Vehicle("CGHH-35", VehicleType.BUS, Calendar.getInstance(), null)
    val car17 =Vehicle("MMDD-36", VehicleType.CAR, Calendar.getInstance(), "CARD1")
    val car18 =Vehicle("CGHH-37", VehicleType.CAR, Calendar.getInstance(), "CARD1")
    val car19 =Vehicle("CGHH-38", VehicleType.CAR, Calendar.getInstance(), "CARD29")
    val car20 =Vehicle("MMDD-39", VehicleType.CAR, Calendar.getInstance(), "CARD1")
    val car21 =Vehicle("CGHH-40", VehicleType.CAR, Calendar.getInstance(), null)
    val car22 =Vehicle("MMDD-41", VehicleType.CAR, Calendar.getInstance(), "CARD1")

    val cars = mutableSetOf<Vehicle>()
    val parking1 = Parking(cars)
    parking1.addVehicle(car1)
    val parkSpace1 =ParkingSpace(car1, parking1)
    parking1.addVehicle(car3)
    val parkSpace2 =ParkingSpace(car3, parking1)
    parking1.addVehicle(car4)
    val parkSpace3 =ParkingSpace(car4, parking1)

    parkSpace1.checkOutVehicle("CGHH-10",car1.type)
    parkSpace2.checkOutVehicle("MMDD-12",car3.type)
    parkSpace3.checkOutVehicle("CGHH-13",car4.type)

    parking1.showEarnings()
    parking1.getAllPlates()

}