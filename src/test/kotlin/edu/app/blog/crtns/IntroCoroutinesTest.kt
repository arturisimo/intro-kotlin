package edu.app.blog.crtns

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread


class IntroCoroutinesTest {

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")

    @Test
    fun coroutines() {
        helloWorld()
        helloWorld2()
    }

    @Disabled
    @Test
    fun coroutinesVsThread() {
        points()
        pointsThread()
    }

    private fun helloWorld() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(5000L) // non-blocking delay for 1 second (default time unit is ms)
            log("World!") // print after delay
        }
        log("Hello") // main coroutine continues while a previous one is delayed
    }

    private fun helloWorld2() = runBlocking { // this: CoroutineScope
        launch { doWorld() }
        log("Hello")
    }

    // this is your first suspending function
    private suspend fun doWorld() {
        delay(1000L)
        log("World!")
    }

    private fun points() = runBlocking {
        repeat(100_000) { // launch a lot of coroutines
            launch {
                delay(5000L)
                log(".")
            }
        }
    }

    private fun pointsThread() = run {
        repeat(100_000) {
            thread {
                Thread.sleep(5000L)
                log(".")
            }
        }
    }


    private fun log(msg: String) = println("${LocalDateTime.now().format(formatter)} | ${Thread.currentThread()} | $msg")
}



