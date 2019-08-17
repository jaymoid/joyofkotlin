package com.fpinkotlin.recursion.exercise01

import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

val byteGen: Gen<Int> = Gen.Companion.choose(Byte.MIN_VALUE.toInt(), Byte.MAX_VALUE.toInt())

class AddTest : StringSpec() {
    init {
        "add" {
            forAll(gena= byteGen, genb = byteGen, iterations = 10) { a: Int, b: Int ->
                println("a: $a b $b")
                add(a, b) == a + b
            }
        }
    }
}
