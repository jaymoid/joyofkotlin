package com.fpinkotlin.recursion.exercise06

// Exercise 4.6
// Write this abstracted function and call it foldRight. Then write the string function in terms
// of foldRight.
fun <T, U> foldRight(list: List<T>, identity: U, f: (T, U) -> U): U {
    fun go (l: List<T>, acc: U): U =
        if (l.isEmpty())
            acc
        else
            f(l.head(), go(l.tail(), acc))
    
    return go(list, identity)
}

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

fun sum(list: List<Int>): Int = foldRight(list, 0) { a, b -> a + b}

fun string(list: List<Char>): String = foldRight(list, "") { a, b -> a + b}
