package com.fpinkotlin.recursion.exercise13

import io.kotlintest.assertSoftly
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.specs.StringSpec

class UnfoldTest : StringSpec(
    {
        "isolated unfold tests" {
            assertSoftly {
                unfold(0, { x -> x + 1 }) { x -> x < 2 } == (0 until 2).toList()
                unfold(631, { x -> x + 1 }) { x -> x < 794 } == (631 until 794).toList()
                unfold(0, { x -> x + 1 }) { x -> x < 573 } == (0 until 573).toList()
            }
        }
    }) {
    init {
        "unfold" {
            forAll(10, Gen.choose(0, 1_000), Gen.choose(0, 1_000)) { a: Int, b: Int ->
                println("unfold $a $b")
                a > b ||  unfold(a, { x -> x + 1 }) { x -> x < b }  == (a until b).toList()
            }
        }
    }
}
