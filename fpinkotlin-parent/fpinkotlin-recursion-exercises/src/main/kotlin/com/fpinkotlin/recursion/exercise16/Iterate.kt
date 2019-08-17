package com.fpinkotlin.recursion.exercise16

//Exercise 4.16
//
// Define the iterate function that works like unfold, except instead of calling itself recursively until a condition is
// met, it calls itself a given number of times.
//
// Hint
// Start with a copy of the unfold function and change the last parameter and the condition.

fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {

    tailrec fun go (x: T, acc: List<T> = emptyList()): List<T> =
        if (acc.size < n)
            go (f(x), acc + x)
        else
            acc

    return go(seed)
}
