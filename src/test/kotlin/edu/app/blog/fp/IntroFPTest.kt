package edu.app.blog.fp


import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class IntroFPTest {

    @Test
    fun `ignoring unwanted destructured value with an underscore`() {
        val (_, right) = Pair(1, 2)
        assertEquals(2, right)
    }


    @Test
    fun `proving lambdas`() {
        //anonymous function
        val double: (Int) -> Int = fun(i: Int) = i * 2
        assertEquals(2, double(1))

        // Lambda expression Function of type (Int) -> Int
        val triple: (Int) -> Int = { i: Int -> i * 3 }
        assertEquals(3, triple(1))

        // Lambda expression Function of type (Int, Int) -> Int
        val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
        assertEquals(4, sum(2,2))

        // Lambda expression Function of type () -> Unit
        val sayHello: () -> Unit = { println("hello") }
        sayHello()

        val list = listOf(1, 2, 3, 4)
        val list2 = listOf("[1]", "[2]", "[3]", "[4]")
        val result = list.map{ n: Int -> "[$n]" }
        assertEquals(list2, result)
        val result2 = list.map{"[$it]"}
        assertEquals(list2, result2)
        // join to string
        assertEquals("1|2|3|4", list.joinToString ( "|" ){ "$it" })
    }

    @Test
    fun `proving function references as objects`() {
        fun suma(a: Int, b: Int): Int = a + b
        val sumObject: (Int, Int) -> Int = ::suma
        assertEquals(4, sumObject(2, 2))

        fun getRealGrade(x: Double) = x
        fun getGradeWithPenalty(x: Double) = x - 1

        fun getScoringFunction(isCheater: Boolean): (Double) -> Double {
            if (isCheater) {
                return ::getGradeWithPenalty
            }
            return ::getRealGrade
        }

        val honestStudent = getScoringFunction(false)
        assertEquals(9.0, honestStudent(9.0))

        val cheaterStudent = getScoringFunction(true)
        assertEquals(8.0, cheaterStudent(9.0))

        // sample 2
        applyActionToString("bye", ::actionReverse)

        // sample 3
        fun composition(value: Int, y: (Int) -> Int, g: (Int) -> Int): Int = y(g(value))
        fun sum2(a: Int) = a + 2
        fun multi3(a: Int): Int = a * 3
        assertEquals(5, composition(1, ::sum2, ::multi3))

        /* sample 4
        println(Person("pepe", "perez")::fullName)
        val personGenerator: (String, String) -> Person = ::Person
        val pepePerez: Person = personGenerator("pepe", "perez")
        assertEquals("pepe perez", pepePerez::fullName) */
    }

    private fun applyActionToString(string: String, action: (String) -> Unit) = action(string)
    private fun actionReverse(s: String) = println("${s.reversed()} ${s.uuid()}")


    class Person(private val name: String, private val lastname: String) {
        fun fullName(): String {
            return("$name $lastname")
        }
    }


    @Test
    fun `proving trailing lambdas`() {
        applyAction("hi", "bye") { s: String ->
            println("$s ${s.uuid()}")
        }
    }

    private fun applyAction(vararg s: String, action: (String) -> Unit) = s.forEach(action)

    private fun String.uuid(): String = UUID.nameUUIDFromBytes(this.encodeToByteArray()).toString()

   @Test
   fun `proving predicates`() {
       val originalText = "I don't know... what to say..."
       fun isNotDot(c: Char): Boolean = c != '.'
       val textWithoutDots = originalText.filter(::isNotDot)
       assertEquals("I don't know what to say", textWithoutDots)

       //simplying using syntactic sugar using lambdas
       val text = "..."
       assertEquals("", text.filter { c -> c != '.' })
   }

    @Test
    fun `sorting`() {

        val isAscending: Boolean = true
        val list = mutableListOf(2,1,3,4,5,6)

        val comparator: (Int, Int) -> Int = if (isAscending) ::minOf else ::maxOf

        sort(list, comparator)
        list.forEach { e -> print("$e ") }
    }

    @Test
    fun testEquality() {
        val expected = 2
        val actual = 3

        assertNotEquals(expected, actual)
    }

    private fun sort(array: MutableList<Int>, comparator: (Int, Int) -> Int) {
        for (i in 0 until array.size - 1) {
            for (j in 0 until array.size - i - 1) {
                if (comparator(array[j], array[j + 1]) == array[j + 1]) {
                    val temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
    }

    @Test
    fun `proving scope functions`(){
        assertEquals("ES", getCountry("ES"))
        assertEquals("GB", getCountry("UK"))
        assertNull(getCountry(null))
    }

    val mapToEPS = mapOf("UK" to "GB")

    private fun getCountry(country: String?): String? =
        mapToEPS[country]?: country

}

data class News(
    private val visible: Boolean,
    private val publishedAt: Date,
)
