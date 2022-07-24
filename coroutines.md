## Couroutines

Las [coroutines](https://github.com/Kotlin/kotlinx.coroutines) cr es un patrón de diseño de concurrencia. Conceptualmente es similar a un thread, en el sentido que permite ejecutar código de forma concurrente, pero no está vinculado a un thread en concreto, ya 
que una cr permite suspender la ejecución en un hilo y reanudarlo en otro. Los cr se consideran thread ligero

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    }

Un ejemplo de cr sería: 

    fun main() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            doWorld() // suspending function
        }
        println("Hello") // main coroutine continues while a previous one is delayed
    }
    suspend fun doWorld() {
        delay(5000L) // non-blocking delay for 5 second
        println("World!") // print after delay
    }
    Sat Jul 02 20:48:55 CEST 2022 | Hello
    Sat Jul 02 20:49:00 CEST 2022 | World!

Las cr sólo se pueden ejecutar en el *CoroutineScope*. *Suspending functions* se pueden ejecutar para suspender la ejecución de la cr.

Las cr consumen menos recursos que los threads de java

**Leer**

[kotlinx.cotoutines 1.6.3](https://kotlinlang.org/api/kotlinx.coroutines/)
