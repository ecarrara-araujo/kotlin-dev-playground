package grokkingalgorithms.recursion


fun main() {
    val integerNumbers = listOf(1, 2, 3, 4, 5, 6, 7) //sum = 28
    println(integerNumbers.sumAll())
    println(integerNumbers.sum())
    println(integerNumbers.totalCount())
    println(integerNumbers.recursiveHighest())
}

// =======================================================================================================

// Given an array of numbers, write a recursive function that returns the sum of all numbers in the array
fun List<Int>.sum(indexesRange: IntRange = 0..size): Int {
    return if (indexesRange.step == 1 && indexesRange.first == indexesRange.last) {
        this[indexesRange.first]
    } else {
        this[indexesRange.first] + sum(indexesRange.first + 1..lastIndex)
    }
}

fun List<Int>.sumAll(): Int {
    fun List<Int>.sum(numbers: List<Int>): Int {
        return if (numbers.size == 1) { // base case: list has one element, so return that element
            numbers.first()
        } else { // recursive case: sum the current element with the of all other elements
            numbers.first() + sum(numbers.slice(1..numbers.lastIndex))
        }
    }

    return sum(this)
}

// =======================================================================================================

// Given a list of items write a recursive function that return the total number of items in the list
// A list [A, B, C, D] -> totalCount() returns 4

fun <T> List<T>.totalCount(): Int {
    fun recursiveCount(remainingList: List<T>): Int {
        return if (remainingList.size == 1)
            1 // base case
        else
            1 + recursiveCount(remainingList.slice(1..remainingList.lastIndex)) // recursive case
    }

    return recursiveCount(this)
}


// =======================================================================================================

// Given a list of numbers write a recursive function that returns the highest value in a list
// A list of numbers [1, 2, 3, 4, 5, 6] -> recursiveHighest() returns 6

fun List<Int>.recursiveHighest(currentHighestValue: Int = first(), index: Int = 0): Int {
    return if (index == lastIndex) {
        if (currentHighestValue > last()) currentHighestValue else last()
    } else {
        if (currentHighestValue > this[index])
            recursiveHighest(currentHighestValue, index + 1)
        else
            recursiveHighest(this[index], index + 1)
    }
}