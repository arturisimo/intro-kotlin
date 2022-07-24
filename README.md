## Kotlin


## InteliJ

Terminal Alt+F12

## gradle build

Construir

    gradle build

Mostrar tareas

    gradle tasks

Ejecutar test

    gradle test

Genera un reporte file:/[BUILD_PATH]/reports/tests/test/index.html

Ejecutar springboot con perfil dev

    gradle bootRun --args='--spring.profiles.active=dev'

Depurar springboot

    gradle bootRun --debug-jvm


eXcluir tarea

    gradle build -x test    

## Aplicación

* http://localhost:8080/
* http://localhost:8080/article/reactor-bismuth-is-out

* http://localhost:8080/api/article/
* http://localhost:8080/api/article/reactor-aluminium-has-landed

## Null Safety in Kotlin

Una de las características de Kotlin es **[null-safety](https://www.baeldung.com/kotlin/null-safety)**; los objetos por defecto no aceptan valores nulos, para sea nullable tenemos que generarlo explicitamente. De esta forma evitamos que se produzcan NullPointerException en tiempo de ejecución sin necesidad de comprobaciones.

    var nombre: String = null
    // error: null can not be a value of a non-null type String

Variable nullable: **?**

    var nombre: String? = null

Desactivar comprobación de nulos: Con el operador **!!** hacemos que el compilador no compruebe si puede ser null y por lo tanto compilará sin problemas, 

    var nombre: String? = null
    var longitud: Int = nombre!!.length
    // Exception in thread "main" kotlin.KotlinNullPointerException

LLamadas seguras

    var nombre: String? = null
    var longitud: Int? = nombre?.length
    println("Longitud: ${longitud}")
    //Longitud: null 

El operador Elvis **?:** permite definir un valor alternativo si se encuentra un null

    var nombre: String? = null
    var longitud: Int = nombre?.length ?: 0
    println("Longitud: ${longitud}")
    // Longitud: 0

## Soporte JSR-305 support

Kotlin se ha diseñado para que sea interoperable con Java. Como en java los objetos son nullables por lo que es necesaria relajar la política null-safety de kotlin con los **platform types** 

https://kotlinlang.org/docs/java-interop.html#jsr-305-support

## Extensions en Kotlin

Kotlin ofrece la posibilidad de ampliar una clase con nuevas funciones sin tener que utilizar clases Util con métodos estáticos mediante **funciones de extensión** 

https://kotlinlang.org/docs/extensions.html#extension-functions

## Annotation Processsors

Kapt Kotlin Annotation Processing Tool

https://kotlinlang.org/docs/kapt.html

## mockk

mocking library for Kotlin

https://mockk.io/

## Nuevo proyecto spring boot con Kotlin

    $ mkdir blog && cd blog
    $ curl https://start.spring.io/starter.zip -d language=kotlin -d dependencies=web,mustache,jpa,h2,devtools -d packageName=edu.app.blog -d name=Blog -o blog.zip

## [Coroutines](coroutines.md)

## [Functional Programing](fp.md)


## postgres

docker run -it --rm postgres psql -h local.postgres -p 5432:5432 -U postgres 


## Tutorial

* https://docs.spring.io/spring-framework/docs/current/reference/html/languages.html
* https://www.youtube.com/playlist?list=PLlFc5cFwUnmxOJL0GSSZ1Vot4KL2Vwe7x
* https://spring.io/guides/tutorials/spring-boot-kotlin/
* https://github.com/spring-guides/tut-spring-boot-kotlin
* https://github.com/spring-guides/tut-spring-webflux-kotlin-rsocket
