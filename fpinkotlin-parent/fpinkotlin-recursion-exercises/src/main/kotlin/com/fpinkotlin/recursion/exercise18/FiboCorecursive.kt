package com.fpinkotlin.recursion.exercise18

import java.math.BigInteger

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

fun <T, U> map(list: List<T>, f: (T) -> U): List<U> =
    foldLeft(list, listOf()) { acc, elem -> acc + f(elem) }

fun <T> iterate(seed: T, f: (T) -> T, n: Int): List<T> {
    tailrec fun iterate_(acc: List<T>, seed: T): List<T> =
        if (acc.size < n)
            iterate_(acc + seed, f(seed))
        else
            acc
    return iterate_(listOf(), seed)
}

//Exercise 4.18
//
//Define a corecursive version of the Fibonacci function producing a string representing the first n Fibonacci numbers.
fun fibonacciList(n: Int): List<BigInteger> =
    iterate(Pair(BigInteger.ZERO, BigInteger.ONE), { (a, b) -> Pair(b, a + b) }, n + 1)
        .map { it.first }

fun fiboCorecursive(number: Int): String = makeString(fibonacciList(number), ",")

fun <T> makeString(list: List<T>, separator: String): String =
    foldLeft(list, "") { acc: String, x: T -> acc + (if (acc != "") "," else "") + x }
