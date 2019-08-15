package com.fpinkotlin.recursion.exercise03

import java.math.BigInteger

// “Exercise 4.3
// Create a tail-recursive version of the Fibonacci function.
//
// Hint
// If you think about a loop-based implementation, as when you created the sum function, you know that you should use
// two variables for keeping track of the two previous values. These variables would then translate into parameters for
// a helper function. These parameters will be of type BigInteger in order to allow computing big values.”

// n:  1 2 3 4 5 6 7  8
// fib:1 1 2 3 5 8 13 21
fun fib(x: Int): BigInteger {
    tailrec fun go(nth: Int, lastTwo: Pair<BigInteger, BigInteger>): BigInteger {
        return if (nth == x)
            lastTwo.second
        else {
            val (a, b) = lastTwo
            go(nth + 1, Pair(b, a + b))
        }
    }

    return go(1, Pair(1.toBigInteger(), 1.toBigInteger()))
}
