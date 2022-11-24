package grokkingalgorithms.recursion

fun main() {
    countdown(10)
}

fun countdown(startNumber: Int) {
    println(startNumber)
    if (startNumber <= 1) return
    countdown(startNumber - 1)
}