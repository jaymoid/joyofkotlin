package com.fpinkotlin.functions.exercise07

class Functions

fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

val compose = { x: (Int) -> Int -> { y: (Int) -> Int -> { z: Int -> x(y(z)) } } }

fun <T, U, V> higherCompose(): ((U) -> V) -> ((T) -> U) -> (T) -> V =
    { f ->
        { g ->
            { x -> f(g(x)) }
        }
    }

fun <T, U, V> higherAndThen(): ((T) -> U) -> ((U) -> V) -> (T) -> V =
    { f: (T) -> U ->
        { g: (U) -> V ->
            { x: T -> g(f(x)) }
        }
    }

// “Write a fun function to partially apply a curried function of two arguments to its first argument.”
fun <A, B, C> partialA(a: A, f: (A) -> (B) -> C): (B) -> C = f(a)

