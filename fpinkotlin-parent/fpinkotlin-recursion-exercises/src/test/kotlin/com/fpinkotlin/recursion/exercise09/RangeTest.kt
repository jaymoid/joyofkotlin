package com.fpinkotlin.recursion.exercise09

import io.kotlintest.assertSoftly
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class RangeTest : StringSpec(
    {
        "isolated range tests" {
            assertSoftly {
                range(1, 10) shouldBe (1 until 10).toList()
                range(0, 0) shouldBe (0 until 0).toList()
            }
        }
    }) {


    init {
        "range" {
            forAll(shortGen, shortGen) { a: Int, b: Int ->
                println("range($a, $b)")
                range(a, b) == (a until b).toList()
            }
        }
    }
}

val shortGen: Gen<Int> = Gen.Companion.choose(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt())
