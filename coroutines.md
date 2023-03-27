## Couroutines

Las [coroutines] se consideran thread muy ligero, se pueden ejecutar un gran número sin impacto.

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    }

Una CR se tiene que llamar dentro de un scope llamado **CoroutineScope**. 
La más simple se puede definir en un bloque **runBlocking** se bloquea la ejecución hasta que todas las CR han terminado


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
