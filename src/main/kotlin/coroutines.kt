import kotlinx.coroutines.*

suspend fun doSomething() {
    delay(1000L)
}

fun main() = runBlocking {
    val deffered = GlobalScope.async {
        delay(2000L)
        10L
    }
    println(deffered.await())

    val job = GlobalScope.launch { // launch a new coroutine in background and continue
        delay(5000L) // non-blocking delay for 5 second (default time unit is ms)
        println("World!") // print after delay
        10L
    }
    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive

    //runBlocking {
    job.join()
}
