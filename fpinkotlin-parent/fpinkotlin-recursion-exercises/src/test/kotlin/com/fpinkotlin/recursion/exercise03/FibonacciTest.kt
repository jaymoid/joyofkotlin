package com.fpinkotlin.recursion.exercise03

import io.kotlintest.assertSoftly
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class FibonacciTest : StringSpec(
    {
        // n:  0 1 2 3 4 5 6  7  8
        // fib:1 1 2 3 5 8 13 21 34
        "simple ones" {
            assertSoftly {
                0 shouldBeFib 0
                1 shouldBeFib 1
                2 shouldBeFib 1
                3 shouldBeFib 2
                4 shouldBeFib 3
                5 shouldBeFib 5
                6 shouldBeFib 8
            }
        }
    }) {

    init {
        "fibonacci" {
            forAll(100, Gen.choose(3, 30_000)) { n ->
                println(n)
                fib(n) == fib(n - 1) + fib(n - 2)
            }
        }
    }
}

private infix fun Int.shouldBeFib(expected: Int) {
    fib(this) shouldBe expected.toBigInteger()
}
