package edu.app.blog

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IntroKotlinTest {

    @Test
    fun `proving default values in parameters`() {
        assertEquals("Hola, planeta cruel", helloWorld("planeta"))
        assertEquals("Hola, mundo lindo", helloWorld(adjetivo = "lindo"))
    }
    private fun helloWorld(sustantivo: String ="mundo", adjetivo: String="cruel") = "Hola, $sustantivo $adjetivo"

    @Test
    fun `proving extensions`() {
        assertEquals("0.05%", 5.percentFormat())
    }
    private fun Int.percentFormat(): String = "${(this/100.00)}%"


    @Test
    fun `proving extracting values by destructuring`() {
        val (one, two) = Pair(1, 2)
        assertEquals(1, one)
        assertEquals(2, two)
    }

    data class SomeMutableData(var i:Int)

    var name: String? = null
    var surname: String = "Moskala"
    private val fullName: String
        get() = name?.let { "$it $surname" }?: kotlin.run { "" }

    @Test
    fun `provin nullables`() {
        assertEquals("", fullName)
        name = "Maja"
        assertEquals("Maja Moskala", fullName)
    }

    @Test
    fun `provin require`() {

        val iae: IllegalArgumentException = assertThrows<IllegalArgumentException> {
            val num: Long = factorial(-1)
            println(num)
        }
        assertEquals("Cannot calculate factorial of -1 because it is smaller than 0", iae.message)
    }

    private fun factorial(n: Int): Long {
        require(n >= 0) {
            "Cannot calculate factorial of $n because it is smaller than 0"
        }
        return if (n <= 1) 1 else factorial(n - 1) * n
    }

    fun Int.factorial(): Int = (1..this).product()

    fun Iterable<Int>.product(): Int = fold(1) { acc, i -> acc * i }


}
