# FP en kotlin

Una función de **orden superior** es una función que toma funciones como parámetros o devuelve una función.

En kotlin se pueden usar funciones como un tipo 

    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

**trailing lambdas** si el último parámetro de una función es una función, entonces una expresión lambda pasada como el argumento correspondiente se puede colocar fuera de los paréntesis:

**Underscore** Si el parámetro de un lamba no se usa se puede usar underscore

    map.forEach { (_, value) -> println("$value!") }

**Sequences**

Sequences are lazy, so intermediate functions for Sequence processing don’t do any calculations. Instead, they return a new Sequence that decorates
the previous one with the new operation. All these computations are evaluated during a terminal operation like toList or count. So they are better to process heavy objects or for bigger
collections with more than one processing step.


**Lecturas**

* Functional Programming in Kotlin. Manning
