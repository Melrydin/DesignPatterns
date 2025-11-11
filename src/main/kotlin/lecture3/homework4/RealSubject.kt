package lecture3.homework4

import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

class RealSubject(val imagePath: String) : Subject {

    private var bufferedImage: BufferedImage = ImageIO.read(File(imagePath))

    override fun operation(degrees: Int) {
        println(">>> [RealImage] Start rotation ($degrees°) for ${imagePath}...")

        val rads = Math.toRadians(degrees.toDouble())
        val cos = abs(cos(rads))
        val sin = abs(sin(rads))
        val oldWidth = bufferedImage.width
        val oldHeight = bufferedImage.height
        val newWidth = (oldWidth * cos + oldHeight * sin).toInt()
        val newHeight = (oldWidth * sin + oldHeight * cos).toInt()

        val rotatedImage = BufferedImage(newWidth, newHeight, bufferedImage.type)
        val g2d = rotatedImage.createGraphics()

        val transform = AffineTransform()
        transform.translate((newWidth - oldWidth) / 2.0, (newHeight - oldHeight) / 2.0)
        transform.rotate(rads, oldWidth / 2.0, oldHeight / 2.0)

        g2d.transform = transform

        g2d.drawImage(bufferedImage, 0, 0, null)
        g2d.dispose()

        val outputFile = getNewFilePath(degrees)
        val formatName = File(imagePath).extension
        ImageIO.write(rotatedImage, formatName, File(outputFile))

        println(">>> [RealImage] Rotation complete. Saved as: $outputFile")
    }

    private fun getNewFilePath(degrees: Int): String {
        val originalFile = File(imagePath)
        val name = originalFile.nameWithoutExtension
        val ext = originalFile.extension
        val parentDir = originalFile.parent
        return "$parentDir/${name}_ROTATED_$degrees.$ext"
    }
}