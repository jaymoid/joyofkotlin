package com.fpinkotlin.recursion.exercise08


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

// Exercise 4.8
// Define the reverse function using only the append version of + without resorting to concatenation.
//
// Hint
// What you need for this exercise is to define the prepend function while not using concatenation. Try to start with a
// function copying a list through a left fold.

// this s
fun <T> prepend(list: List<T>, elem: T): List<T> = foldLeft(list, listOf(elem)) {a, b -> a + b }

fun <T> reverse(list: List<T>): List<T> = foldLeft(list, listOf(), ::prepend)
