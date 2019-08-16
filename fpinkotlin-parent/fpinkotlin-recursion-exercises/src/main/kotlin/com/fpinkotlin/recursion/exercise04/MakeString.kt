package com.fpinkotlin.recursion.exercise04

//Exercise 4.4
//Write a tail-recursive version of the makeString function. (Try not to look at the tail-recursive version of sum.)

fun <T> makeString(list: List<T>, delim: String): String {
    tailrec fun go (l: List<T>, acc: String): String =
        if (l.isEmpty()) {
            acc
        } else {
            val newAcc: String = acc + (if (l != list) delim else "") + l.head().toString()
            go(l.tail(), newAcc)
        }

    return go (list, "")
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
