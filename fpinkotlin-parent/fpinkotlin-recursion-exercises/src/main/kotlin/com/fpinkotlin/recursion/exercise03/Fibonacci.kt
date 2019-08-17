package com.fpinkotlin.recursion.exercise03

import java.math.BigInteger

// “Exercise 4.3
// Create a tail-recursive version of the Fibonacci function.
//
// Hint
// If you think about a loop-based implementation, as when you created the sum function, you know that you should use
// two variables for keeping track of the two previous values. These variables would then translate into parameters for
// a helper function. These parameters will be of type BigInteger in order to allow computing big values.”

// n:   0 1 2 3 4 5 6  7  8
// fib: 1 1 2 3 5 8 13 21 34
fun fib(x: Int): BigInteger {
    tailrec fun go(n: Int, a: BigInteger, b: BigInteger): BigInteger =
        if (n == x) b
        else go(n.inc(), b, a + b)

    return if (x == 0) BigInteger.ZERO else go(1, BigInteger.ZERO, BigInteger.ONE)
}
