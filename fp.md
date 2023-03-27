# FP en kotlin

Kotlin da soporte a funciones como tipo *Function*, por lo que se puede asignar a una variable, puede pasar como argumento, devolver como resultado. De forma que esta función: 

    fun suma(a: Int, b: Int): Int = a + b

Es de tipo *(Int, Int) -> Int*

    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

function references: Kotlin permite referenciar a funciones como objetos

    val sumaObject = ::suma

Las funciones se pueden crear en tiempo de ejecución; se pueden definir funciones anónimas o expresiones lambda

 * Function: fun sum(a: Int, b: Int): Int = a + b
 * Función anónima: fun(a: Int, b: Int): Int = return a + b
 * Expresion lambda: { a: Int, b: Int -> a + b }


**trailing lambdas** si el último parámetro de una función es una función, entonces una expresión lambda pasada como el argumento correspondiente se puede colocar fuera de los paréntesis:

**Underscore** Si el parámetro de un lamba no se usa se puede usar underscore

    map.forEach { (_, value) -> println("$value!") }

**predicate**: función que toma un argumento y devuelve un boolean

Hay cinco **funciones de ámbito** en Kotlin, que nos ayudan a organizar nuestro código e implementar alguna funcionalidad en el objeto: apply, also, with, let, run
apply y also devuelven el objeto del contexto (this). let, run y with devuelven un lambda (it).

    fun prinDayConsole() = run {
        val (day, month, year) = List(3) { readln() }
        "$month.$day.$year"
    }.let(::print)


## Arrow    

Arrow es una librería para programación funcional tipada en Kotlin que nos proporciona tipos de datos más populares como Option, Either o Validated.


**Sequences**

Sequences are lazy, so intermediate functions for Sequence processing don’t do any calculations. Instead, they return a new Sequence that decorates
the previous one with the new operation. All these computations are evaluated during a terminal operation like toList or count. So they are better to process heavy objects or for bigger
collections with more than one processing step.


**Lecturas**

* Functional Programming in Kotlin. Manning
