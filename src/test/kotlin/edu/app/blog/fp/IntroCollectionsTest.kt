package edu.app.blog.fp

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.system.measureTimeMillis

class IntroCollections {

    val giataCSV: File = File("C:\\Users\\arturo.perez\\dev\\tui\\giata-mapper-api\\src\\main\\resources\\giata_details_mapping.csv")

    @Test
    fun `list vs sequence`() {
        var numHotels = 0

        val elapsedSeq = measureTimeMillis {
            numHotels = giataCSV.useLines { lines -> // The type of `lines` is Sequence<String>
                lines.drop(1) // Drop descriptions of the columns
                    .mapNotNull { it.split(",").getOrNull(7) }
                    .filter { "28010" in it }
                    .count()
                //.let { println(it) }
            }
        }
        println("$numHotels - $elapsedSeq ms seq")

        val elapsedList = measureTimeMillis {
            numHotels = giataCSV.readLines()
                .drop(1)
                .mapNotNull { it.split(",").getOrNull(7) }
                .count { "28053" in it }
            //.let(::println)
        }

        println("$numHotels - $elapsedList ms list")

    }

    @Test
    fun `map`() {

        val elapsedSeq = measureTimeMillis {
            val hotels: List<Giata> = giataCSV.useLines { lines -> // The type of `lines` is Sequence<String>
                lines.drop(1) // Drop descriptions of the columns
                    .mapNotNull {
                        val (hotel_id,latitude,longitude, hotel_name,street,city,country,postal_code) = it.split(',')
                        Giata(hotel_id.toLong(), latitude.secureToFloat(),longitude.secureToFloat(),hotel_name,street,city,country,postal_code)
                    }.toList()
            }

            println("${hotels.size} hotels")

            hotels.associateBy { it.hotelId }
                .filter { it.value.postalCode=="" }
                .count()
            //.let(::println)

            val mapCountries : Map<String, List<Giata>> = hotels.groupBy{ it.country }.toSortedMap()
            mapCountries
                .onEach{println("${it.key} - ${it.value.size}")}


        }
        println("$elapsedSeq ms seq")

    }

    operator fun <T> List<T>.component6(): T = get(5)
    operator fun <T> List<T>.component7(): T = get(6)
    operator fun <T> List<T>.component8(): T = get(7)
    fun String?.secureToFloat(): Float? = (if (this=="") {null} else {this})?.toFloat()
}

data class Giata(
    val hotelId: Long,
    val latitude: Float?=null,
    val longitude: Float?=null,
    val hotelName: String,
    val street: String,
    val city: String,
    val country: String,
    val postalCode: String
)
