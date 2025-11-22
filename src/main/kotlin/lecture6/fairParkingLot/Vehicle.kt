package lecture6.fairParkingLot

class Vehicle(val parkingLot: ParkingLot, private val vehicleId: Int) : Thread() {
    override fun run() {
        parkingLot.enter(vehicleId)
        parkingLot.leave(vehicleId)
    }
}