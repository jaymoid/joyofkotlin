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
    tailrec fun foldLeft(list: List<T>, acc: U, f: (U, T) -> U): U =
        if (list.isEmpty())
            acc
        else
            foldLeft(list.tail(), f(acc, list.head()), f)
    return foldLeft(list, z, f)
}

fun fibo(number: Int): String {
    tailrec fun fibo(acc: List<BigInteger>, acc1: BigInteger,
                      acc2: BigInteger, x: BigInteger): List<BigInteger> =
        when (x) {
            BigInteger.ZERO -> acc
            BigInteger.ONE -> acc + (acc1 + acc2)
            else -> fibo(acc + (acc1 + acc2), acc2, acc1 + acc2,
                          x - BigInteger.ONE)
        }
    val list = fibo(listOf(),
                     BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(number.toLong()))
    return makeString(list, ", ")
}

fun <T> makeString(list: List<T>, separator: String): String =
    when {
        list.isEmpty() -> ""
        list.tail().isEmpty() -> list.head().toString()
        else -> list.head().toString() +
            foldLeft(list.tail(), "") { x, y -> x + separator + y}
    }

fun main() {
    val fibTo19: List<Pair<Int, String>> =
        (0..100).toList().zip(fibo(19).split(','))

    println(fibTo19)
}
