package lecture3.homework4

import java.io.File

val imageDir = File("images")

fun main() {
    val imageProxies = loadImageProxies()

    println("System ready. ${imageProxies.size} image proxies loaded.")
    println("-------------------------------------------------")

    while (true) {
        println("Available images (enter ‘exit’ to quit):")
        imageProxies.forEachIndexed { index, image ->
            println("$index: ${image.getFilePath()}")
        }
        println("-------------------------------------------------")

        print("Which image would you like to rotate? (Enter the number): ")
        val imageInput = readlnOrNull()

        if (imageInput.equals("exit", ignoreCase = true)) {
            println("Will be terminated...")
            break
        }

        print("By how many degrees (e.g., 90, 180)? ")
        val degreeInput = readlnOrNull()

        try {
            val selection = imageInput?.toIntOrNull()
            val degrees = degreeInput?.toIntOrNull()

            if (selection != null && degrees != null && selection in imageProxies.indices) {

                println("--- Start operation for image $selection ---")
                imageProxies[selection].operation(degrees)
                println("--- Operation completed ---")

            } else {
                if (selection == null || selection !in imageProxies.indices) {
                    println("Invalid image number. Please enter a number between 0 and ${imageProxies.size - 1}.")
                }
                if (degrees == null) {
                    println("Invalid degree value. Please enter a number (e.g., 90).")
                }
            }

        } catch (e: NumberFormatException) {
            println("Error: Please enter valid numbers.")
        }
    }
}

fun loadImageProxies(): List<Proxy> {
    if (!imageDir.exists() || !imageDir.isDirectory) {
        println("Error: Folder ‘images’ not found in project directory.")
        return emptyList()
    }

    println("Scan folder: ${imageDir.absolutePath}")
    val imageProxies = imageDir
        .listFiles { file -> file.extension in listOf("jpg") }
        ?.map { file -> Proxy(file.absolutePath) }
        ?: emptyList()

    if (imageProxies.isEmpty()) {
        println("No images found in the ‘images’ folder.")
    }
    return imageProxies
}