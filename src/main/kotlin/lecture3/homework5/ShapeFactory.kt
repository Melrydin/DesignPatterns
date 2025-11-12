package lecture3.homework5

import kotlinx.serialization.json.Json
import java.io.File

object ShapeFactory {

    private val shapeCache = mutableMapOf<String, Shape>()

    private val jsonParser = Json { ignoreUnknownKeys = true }
    fun getShape(key: String): Shape {
        return shapeCache.getOrPut(key) {
            println("Loading expensive geometry for '$key' from file...")
            loadShapeFromFile(key)
        }
    }

    private fun loadShapeFromFile(key: String): Shape {
        val filePath = "src/main/resources/$key.json"
        val fileContent = File(filePath).readText()

        val points: List<Point> = jsonParser.decodeFromString(fileContent)

        return SharedPolygonShape(points)
    }
}