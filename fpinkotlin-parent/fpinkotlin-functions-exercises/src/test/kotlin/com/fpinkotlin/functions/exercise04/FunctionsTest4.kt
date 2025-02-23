package com.fpinkotlin.functions.exercise04

import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class FunctionsTest4 : StringSpec() {

    init {
        "compose" {
            forAll { x: Int ->
                compose(::square)(::triple)(x) == square(triple(x))
            }
        }
    }
}

