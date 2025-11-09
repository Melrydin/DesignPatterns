package lecture3.homework1

interface Shape2D {
    fun getXPos(): Double
    fun getYPos(): Double
    fun setXPos(x: Double)
    fun setYPos(y: Double)
    fun area(): Double
}

interface IShiftable {
    fun shift(x: Double, y: Double)
}

interface IScalable {
    fun scale(factor: Double)
}