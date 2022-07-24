package edu.app.blog.fp

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class IntroFPTest {

    @Test
    fun `proving trailing lambdas`() {
        applyAction("hi", "bye") { s: String ->
            println("$s ${s.uuid()}")
        }
    }

    private fun applyAction(vararg s: String, action: (String) -> Unit) {
        s.forEach(action)
    }

    private fun String.uuid(): String = UUID.nameUUIDFromBytes(this.encodeToByteArray()).toString()

    @Test
    fun `ignoring unwanted destructured value with an underscore`() {
        val (_, right) = Pair(1, 2)
        Assertions.assertEquals(2, right)
    }

}

data class News(
    private val visible: Boolean,
    private val publishedAt: Date,

)
