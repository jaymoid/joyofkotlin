package com.fpinkotlin.recursion.exercise17

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

//Exercise 4.17
//
//Define a map function that applies a function (T) -> U to each element of a List<T>, producing a List<U>.
//
//Hint
//
//You can define a tail-recursive function or you can define your function in terms of foldLeft or foldRight.
// A good idea would be to start from the copy function you created when defining reverse.
fun <A, B> map(list: List<A>, f: (A) -> B): List<B> = foldLeft(list, emptyList()) { acc: List<B>, a: A -> acc + f(a) }
