# AlkeParking

AlkeParking is a space parking administration tool, allows to create a parking and control 
the amount of Vehicles in and calculates the total amount to pay according with the time parked and the vehicle type.

## Installation
Download the proyect from 

https://github.com/mauropena1/AlkeParking

## Install

java JDK must be installed
[https://www.oracle.com/java/technologies/downloads/]
check $ java -version

install Kotlin compiler 
linux systems
sdk install kotlin

mac and brew
brew install kotlin

windows
download zip file https://github.com/JetBrains/kotlin/releases/tag/v1.6.21

## Run project
run in your terminal: 
```
kotlinc main.kt VehicleType.kt Vehicle.kt Parking.kt ParkingSpace.kt -include-runtime -d main.jar

java -jar main.jar 
```
If every goes right, you should see a random test of checkin a and checkout cars ;)
