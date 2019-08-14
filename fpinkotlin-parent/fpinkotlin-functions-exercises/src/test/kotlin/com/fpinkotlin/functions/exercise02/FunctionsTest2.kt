package com.fpinkotlin.functions.exercise02


import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest2: StringSpec() {

    init {
        "compose" {
            forAll { x: Int ->
                compose(::square, ::triple)(x) == square(triple(x))
            }
        }
    }
}

