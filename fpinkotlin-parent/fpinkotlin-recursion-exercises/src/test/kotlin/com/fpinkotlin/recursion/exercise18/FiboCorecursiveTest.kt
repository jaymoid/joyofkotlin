package com.fpinkotlin.recursion.exercise18

import com.fpinkotlin.recursion.exercise15.fibo
import io.kotlintest.properties.Gen
import io.kotlintest.properties.forAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec


class FiboCorecursiveTest : StringSpec((
        {
            "fibonacci test to 20" {
                fiboCorecursive(20) shouldBe "0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765"
            }
        })) {

//    init {
//        "fibonacci" {
//            forAll(100, Gen.choose(3, 300)) { n ->
//                fiboCorecursive(n - 1) == fiboCorecursive(n).substringBeforeLast(",")
//            }
//        }
//    }
}
