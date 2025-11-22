package lecture6.fairParkingLot

import org.junit.jupiter.api.Test

class ParkingLotTest {

    @Test
    fun parkingLot() {
        val lot = ParkingLot(2)
        val numberOfCars = 10
        val vehicles = ArrayList<Vehicle>()

        for (i in 0 until numberOfCars) {
            vehicles.add(Vehicle(lot, i))
        }
        vehicles.shuffle()

        println("--- Start simulation: Cars start wildly jumbled together ---")
        for (v in vehicles) {
            v.start()
        }
    }

}