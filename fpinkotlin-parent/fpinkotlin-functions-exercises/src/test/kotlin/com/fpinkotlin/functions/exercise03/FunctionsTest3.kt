package com.fpinkotlin.functions.exercise03


import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest3: StringSpec() {

    init {
        "add" {
            forAll { x: Int, y: Int ->
                add(x)(y) == x + y
            }
        }
    }
}

