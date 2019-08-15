package com.fpinkotlin.recursion.exercise01

import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class AddTest: StringSpec() {
    init {
        "add" {
            forAll { a: Int, b: Int ->
                println("a: $a b $b")
//                ( a<0 || b <0) ||
                add(a, b) == a + b
            }
        }
    }
}
