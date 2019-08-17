package com.fpinkotlin.recursion.exercise09

import java.util.ArrayList
import kotlin.math.abs

// Exercise 4.9
// Write a loop-based implementation of a function that produces a list using a starting value, a limit, and the
// function x -> x + 1. You’ll call this function range, and it’ll have the following signature:

fun range(start: Int, end: Int): List<Int> {
    // I'm sorry Simon Peyton Jones, I was told to do this...
    val accumulator: MutableList<Int> = ArrayList(abs(end-start))
    var i: Int = start
    while (i < end)
        accumulator.add(i++)
    return accumulator
}
