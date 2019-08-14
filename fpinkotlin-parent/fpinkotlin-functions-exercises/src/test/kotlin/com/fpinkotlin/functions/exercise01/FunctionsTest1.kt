package com.fpinkotlin.functions.exercise01


import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest1: StringSpec() {

    init {
        "compose" {
            forAll { x: Int ->
                compose(::square, ::triple)(x) == square(triple(x))
            }
        }
    }
}
