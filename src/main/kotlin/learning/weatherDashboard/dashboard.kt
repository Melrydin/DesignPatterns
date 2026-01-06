package learning.weatherDashboard

import kotlinx.coroutines.*

suspend fun fetchFromApi(name: String, delayTime: Long, fail: Boolean = false): String {
    try {
        delay(delayTime)
        if (fail) throw RuntimeException("API $name has crashed!")
        return "Data from $name"
    } finally {
        println("$name: Resources are released...")
    }
}

fun main() = runBlocking {
    println("Start weather-query...")
    supervisorScope {
        val serviceA = async { fetchFromApi("A", 1000L) }
        val serviceB = async { fetchFromApi("B", 500L, true)}
        val serviceC = async { withTimeout(2000L) { fetchFromApi("C", 3000L) }}

        val results = listOf(serviceA, serviceB, serviceC).mapIndexed { index, deferred ->
            val name = if(index == 0) "A" else if(index == 1) "B" else "C"
            try {
                deferred.await()
            } catch (e: TimeoutCancellationException) {
                "Error: API $name Timeout"
            } catch (e: Exception) {
                "Error: ${e.message}"
            }
        }

        println("\n--- Dashboard Status ---")
        results.forEach { println(it) }
    }

    println("Program ended.")

}