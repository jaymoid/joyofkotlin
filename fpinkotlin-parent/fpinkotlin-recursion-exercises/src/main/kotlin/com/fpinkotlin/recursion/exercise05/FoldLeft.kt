package com.fpinkotlin.recursion.exercise05

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

// Exercise 4.5
// Create a generic version of your tail-recursive function that can be used for sum, string, and
// makeString. Call this function foldLeft, then write sum, string, and makeString in terms of this
// new function.

fun <T, U> foldLeft(list: List<T>, z: U, f: (U, T) -> U): U {
    tailrec fun go(l: List<T>, acc: U): U =
        if (l.isEmpty())
            acc
        else
            go(l.tail(), f(acc, l.head()))

    return go(list, z)
}

fun sum(list: List<Int>): Int = foldLeft(list, 0) { acc: Int, x: Int -> x + acc }

fun string(list: List<Char>): String = foldLeft(list, "") { acc: String, x: Char -> acc + x }
