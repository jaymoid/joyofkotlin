package com.fpinkotlin.recursion.exercise07

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

// Exercise 4.7
// Define a reverse function using a fold.
//
// Hint
// Remember that foldRight might overflow the stack when used with long lists, so you should prefer foldLeft as
// often as possible. You should also create the prepend function working on the list and adding an element in
// front of the list.
// Don’t worry about performance. This is a problem you’ll address in chapter 5.
// Make your function work with immutable lists using the + operator.

fun <T> prepend(list: List<T>, elem: T): List<T> = listOf(elem) + list

fun <T> reverse(list: List<T>): List<T> = foldLeft(list, listOf(), ::prepend)
