package grokkingalgorithms

private val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

fun main() {
    println(numbers.binarySearch(6))
    println(numbers.binarySearch(11))
    println(numbers.binarySearch(10))
    println(numbers.binarySearch(0))
    println(numbers.binarySearchRecursive(-1))

    println(numbers.binarySearch(1))
    println(numbers.binarySearch(2))
    println(numbers.binarySearch(-1))
    println(numbers.binarySearch(0))
}

fun <T : Comparable<T>> List<T>.binarySearch(value: T): Int {
    var lower = 0
    var higher = lastIndex
    var mid = size / 2

    while (lower <= higher) {
        when {
            value == this[mid] -> return mid
            value < this[mid] -> {
                higher = mid - 1
                mid = (higher - lower) / 2
            }
            value > this[mid] -> {
                lower = mid + 1
                mid = lower + ((higher - lower) / 2)
            }
        }
    }

    return -1
}

fun <T : Comparable<T>> List<T>.binarySearchRecursive(
    value: T,
    lowerBound: Int = 0,
    upperBound: Int = lastIndex
): Int {
    val mid = lowerBound + (upperBound - lowerBound) / 2
    return when {
        lowerBound > upperBound -> -1
        value == this[mid] -> mid
        value > this[mid] -> binarySearchRecursive(value, mid + 1, upperBound)
        value < this[mid] -> binarySearchRecursive(value, lowerBound, mid - 1)
        else -> -1
    }
}
