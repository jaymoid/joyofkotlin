package com.fpinkotlin.recursion.exercise11

import com.fpinkotlin.recursion.exercise01.inc

fun <T> unfold(seed: T, f: (T) -> T, p: (T) -> Boolean): List<T> {
    val result: MutableList<T> = mutableListOf()
    var elem = seed
    while (p(elem)) {
        result.add(elem)
        elem = f(elem)
    }
    return result
}

//Exercise 4.11
//
//Implement the range function in terms of unfold.

fun range(start: Int, end: Int): List<Int> = unfold(start, ::inc, { it < end })
