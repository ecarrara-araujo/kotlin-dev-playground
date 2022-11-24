package grokkingalgorithms

private val numbers = listOf(9, 5, 5, 6, 2, 2, 1, 6, 8, 9, 2345, -2345)

fun main() {
    println(quickSort(numbers))
}

fun quickSort(list: List<Int>): List<Int> {

    // base case -> empty list or one element list is already ordered
    // recursive case:
    // - choose a pivot
    // - move elements lower than pivot to the left and higher to the right
    // - sum quick sort of left list with pivot with quick sort of right list

    if (list.size in 0..1) return list

    val pivot = list[0]
    val (smaller, bigger) = list.drop(1).partition { it <= pivot }
    return quickSort(smaller) + pivot + quickSort(bigger)
}