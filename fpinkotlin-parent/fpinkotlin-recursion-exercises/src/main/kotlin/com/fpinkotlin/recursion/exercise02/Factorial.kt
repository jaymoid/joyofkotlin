package com.fpinkotlin.recursion.exercise02

// Exercise 4.2 (hard)
// Write a recursive factorial value function.
// Remember that a value function is a function declared with the val keyword”

object Factorial {

    val factorial: (Int) -> Int = { n: Int ->
        fun go(nPrime: Int): Int =
            if (nPrime == 0)
                1
            else
                nPrime * go(nPrime - 1)

        go(n)
    }

    // ah seems they were after the problem of the function being reerenced whilst not init'd
    val factorialBookVersion: (Int) -> Int by lazy {
        { n: Int ->
            if (n == 0)
                1
            else
                n * factorialBookVersion(n - 1)
        }
    }



}
