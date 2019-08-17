package com.fpinkotlin.recursion.exercise01


tailrec fun add(a: Int, b: Int): Int =
    if (b == 0)
        a
    else
        add(a.inc(), b.dec())


fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1
