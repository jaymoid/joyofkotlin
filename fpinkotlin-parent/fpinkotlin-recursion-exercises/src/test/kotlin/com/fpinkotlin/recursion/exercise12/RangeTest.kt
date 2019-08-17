package com.fpinkotlin.recursion.exercise12


import com.fpinkotlin.recursion.exercise09.shortGen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class RangeTest : StringSpec() {
    init {
        "range" {
            forAll(shortGen, shortGen) { a: Int, b: Int ->
                println("range($a, $b)")
                b > a || range(a, b) == (a until b).toList()
            }
        }
    }
}
