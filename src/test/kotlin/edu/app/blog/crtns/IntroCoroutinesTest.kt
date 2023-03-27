package edu.app.blog.crtns

import edu.app.blog.aop.TimeItAnnotationAspect
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread


class IntroCoroutinesTest {

    var logger: Logger = LoggerFactory.getLogger(IntroCoroutinesTest::class.java)

    @Test
    fun simplyCR() = runBlocking { // definición del ambito de la CR
        launch { // launch a new coroutine and continue
            doWorld() // suspending function
        }
        println("Hello") // main coroutine continues while a previous one is delayed
    }
    suspend fun doWorld() {
        delay(5000L) // non-blocking delay for 5 second
        println("World!") // print after delay
    }

    /*

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
            logger.info("World!") // print after delay
        }
        logger.info("Hello") // main coroutine continues while a previous one is delayed
    }

    private fun helloWorld2() = runBlocking { // this: CoroutineScope
        launch { doWorld() }
        logger.info("Hello")
    }

    // this is your first suspending function
    private suspend fun doWorld() {
        delay(1000L)
        logger.info("World!")
    }

    private fun points() = runBlocking {
        repeat(100_000) { // launch a lot of coroutines
            launch {
                delay(5000L)
                logger.info(".")
            }
        }
    }

    private fun pointsThread() = run {
        repeat(100_000) {
            thread {
                Thread.sleep(5000L)
                logger.info(".")
            }
        }
    }
*/
}



