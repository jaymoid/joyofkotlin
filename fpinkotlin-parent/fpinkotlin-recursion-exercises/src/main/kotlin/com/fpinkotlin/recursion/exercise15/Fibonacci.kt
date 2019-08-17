package com.fpinkotlin.recursion.exercise15

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

// Exercise 4.15
//
// Write a tail-recursive function taking an integer n as its argument and returning a string representing the values
// of the Fibonacci numbers from 0 to n, separated by a comma and a space.
//
// Hint
//
// One solution is to use an instance of StringBuilder as the accumulator. StringBuilder is a mutable structure, but
// this mutation won’t be visible from the outside. Another solution is to return a list of numbers and then transform
// it into a String. This solution is easier because you can abstract the problem of the separators by first returning
// a list and then writing a function to turn the list into a comma-separated string.
val <T> List<T>.penultimateIndex: Int
    get() = this.size - 2

fun fibonacciList(number: Int): List<BigInteger> {
    fun nextFib(fibs: List<BigInteger>): BigInteger = fibs[fibs.lastIndex] + fibs[fibs.penultimateIndex]

    // why n+1, most consider 0 to be the first Fib number (see wikipedia)
    tailrec fun go(n: Int, fibs: List<BigInteger>): List<BigInteger> =
        if (n+1 == number)
            fibs
        else
            go(n.inc(), fibs + nextFib(fibs))

    return if (number == 0)
        listOf(BigInteger.ZERO)
    else
        go(0, listOf(BigInteger.ZERO, BigInteger.ONE))
}

fun fibo(number: Int): String = makeString(fibonacciList(number), ",")

fun <T> makeString(list: List<T>, separator: String): String =
    foldLeft(list, "") { acc: String, x: T -> acc + (if (acc != "") "," else "") + x }

fun main() {
    val fibTo19: List<Pair<Int, Int>> =
        (0..100).toList().zip(fibonacciList(20).map { it.toInt() })

    println(fibTo19)
}
