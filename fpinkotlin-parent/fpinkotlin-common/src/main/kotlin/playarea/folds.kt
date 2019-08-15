package playarea

val startList = (1..5).toList()

val foldl = startList.fold("0", { acc: String, i: Int -> "($acc+$i)" })

val foldr = startList.foldRight("0", { i: Int, acc: String -> "($i+$acc)" })

fun main() {
    println("left associative fold: $foldl")
    println("right associative fold: $foldr")

    println("lazy fold of infinite seq2 ... no? $foldr2")

    println("lazy fold of infinite seq3? ... yay! $foldr3")

    println("lazy fold of infinite seq3? $foldr4")

    println("lazy fold of infinite seq? $foldrStopAt10")
}

// in lazy langs I can say:
// foldr const 0 [1..]
val foldr2 = generateSequence(1) { it + 1 }
    .take(10)
    .fold(0) { acc: Int, n: Int -> n }

val foldr3 = generateSequence(1) { it + 1 }
    .foldRight(0) { n: Int, recurseFunction: () -> Int
        -> n
    }

val foldr4 = generateSequence(1) { it + 1 }
    .take(50)
    .foldRight("") { n: Int, recurseFunction: () -> String
        -> recurseFunction() + n.toString()
    }


val foldrStopAt10 = generateSequence(1) { it + 1 }
    .foldRight2("") { n: Int, recurseFunction: () -> String
        ->
            val b: String = recurseFunction()
            if (b.length == 10)
                b
            else
                b + n.toString()
    }

// from https://discuss.kotlinlang.org/t/add-lazy-fold-to-sequence/2141/5
fun <T, A> Sequence<T>.foldRight(initial: A, f: (T, () -> A) -> A): A {
    val it = iterator()

    fun tailFold(): A = if (!it.hasNext())
        initial
    else
        f(it.next(), { tailFold() })

    return tailFold()
}

// Is this ^ the same as v ... ? I'm not sure. It's a bit weird.
// foldr :: (a -> b -> b) -> b -> [a] -> b
// foldr f z xs =
//     case xs of
//              [] -> z
//              (x:xs) -> f x (foldr f z xs)


fun <A,B> Sequence<A>.foldRight2(initial: B, f: (A, () -> B) -> B): B {
    val it = iterator()

    fun tailFold(): B = if (!it.hasNext())
        initial
    else
        f(it.next(), { tailFold() }) //  () -> B is required to stop it being eagerly evaluated

    return tailFold()
}
