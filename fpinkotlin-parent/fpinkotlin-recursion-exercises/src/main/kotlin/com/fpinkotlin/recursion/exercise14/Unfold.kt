package com.fpinkotlin.recursion.exercise14

import com.fpinkotlin.recursion.exercise13.prepend

fun <T> List<T>.head(): T =
    if (this.isEmpty())
        throw IllegalArgumentException("head called on empty list")
    else
        this[0]

fun <T> List<T>.tail(): List<T> =
    if (this.isEmpty())
        throw IllegalArgumentException("tail called on empty list")
    else
        this.subList(1, this.size)

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun foldLeft_(list: List<T>, acc: U, f: (U, T) -> U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft_(list.tail(), f(acc, list.head()), f)
    return foldLeft_(list, z, f)
}


// Exercise 4.14
//
// Can you make a tail recursive version of this function? Try to answer this question in theory before doing the exercise.
//
// Hint
// Think about this: Is unfold a recursive function or a corecursive one?

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    tailrec fun go(x: T, acc: List<T> = emptyList()): List<T> =
        if (p(x))
            go(f(x), acc + x)
        else
            acc

    return go(seed)
}


