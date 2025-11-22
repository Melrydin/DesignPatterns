package lecture6.fairParkingLot

class ParkingLot(var availablePlaces: Int) {
    private var nextVehicleId: Int = 0

    @Synchronized
    fun enter(vehicleId: Int) {
        while(availablePlaces == 0 || nextVehicleId != vehicleId) {
            println("Waiting: Full or wrong order")
            (this as Object).wait()
        }
        availablePlaces--
        println("Car $vehicleId enter: $availablePlaces")
        nextVehicleId++
        (this as Object).notifyAll()
    }

    @Synchronized
    fun leave(vehicleId: Int){
        if (vehicleId < nextVehicleId){
            availablePlaces++
            println("car $vehicleId left: $availablePlaces")
            (this as Object).notifyAll()
        }

    }
}