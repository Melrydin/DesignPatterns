package lecture8.countingLetter

import java.io.File

class LetterCounter(var comparatorStrategy: CounterStrategy) {
    fun countLetters(path: String): Number {
        return comparatorStrategy.letterCount(loadFile(path)).toLong()
    }

    fun loadFile(path: String): String {
        val file = File(path)
        return if (file.exists() && file.isFile) file.readText() else ""
    }
}