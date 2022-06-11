import kotlin.math.*

fun genprimes(mx: Int): ArrayList<Int> {
    var primesh=mutableSetOf<Int>()
    for (i in 2..3) {
        primesh.add(i)
    }
    for (i in 6..mx+1 step 6) {
        for (j in i-1..i+1 step 2) {
            if (j <= mx) {
                primesh.add(j)
            }
        }
    }
    var q=ArrayDeque(listOf(2,3,5,7))
    var p=q.removeFirst()
    val mr=sqrt(mx.toDouble()).toInt()
    while (p <= mr) {
        if (primesh.contains(p)) {
            for (i in p*p..mx step p) {
                primesh.remove(i)
            }
        }
        if (q.size < 2) {
            q.add(q.last()+4)
            q.add(q.last()+2)
        }
        p=q.removeFirst()
    }
    var primes=ArrayList(primesh.distinct())
    primes.sort()
    return primes
}

fun cuban1(mx: Int): ArrayList<Int> {
    var o=ArrayList<Int>()
    val ps=genprimes(mx).toSet()
    for (y in 1..mx) {
        val q=3*y*(y+1)+1
        if (q > mx) {
            break
        }
        if (ps.contains(q)) {
            o.add(q)
        }
    }
    return o
}

fun main() {
    if (cuban1(1000) == listOf(7, 19, 37, 61, 127, 271, 331, 397, 547,
                               631, 919)) {
        print("Pass")
    } else {
        print("FAIL")
    }
    println("")
}
