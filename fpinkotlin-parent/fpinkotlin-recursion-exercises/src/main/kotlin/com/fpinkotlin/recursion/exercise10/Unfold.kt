package com.fpinkotlin.recursion.exercise10

// Exercise 4.10
// Write a generic version of a range-like function that works for any type and any condition.
// As the notion of range works only for numbers, let’s call this function unfold and give it the following signature:
fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun go(x: T, acc: List<T> = emptyList()): List<T> =
        if (p(x))
            go(f(x), acc + x)
        else
            acc

    return go(seed)
}

