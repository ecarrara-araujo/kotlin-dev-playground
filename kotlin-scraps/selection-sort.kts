#!/usr/bin/env kotlin

fun List<Int>.findMinIndex(): Int {
    var minIndex: Int = 0
    var min = first()

    forEachIndexed { index, item ->
        if (item < min) {
            minIndex = index
            min = item
        }
    }

    return minIndex
}

fun List<Int>.findMaxIndex(): Int {
    var maxIndex: Int = 0
    var max = first()

    forEachIndexed {index, item -> 
        if (item > max) {
            maxIndex = index
            max = item
        }
    }
    return maxIndex
}

val numbers = listOf(1, 20, 3123, -4, 52343, -6, 12323)

val minIndex = numbers.findMinIndex()
val maxIndex = numbers.findMaxIndex()
println("Min Index is $minIndex and its value ${numbers[minIndex]}")
println("Max Index is $maxIndex and its value ${numbers[maxIndex]}")

fun List<Int>.selectionSortAscending(): List<Int> = selectionSort(isAscending = true)
fun List<Int>.selectionSortDescending(): List<Int> = selectionSort(isAscending = false)

fun List<Int>.selectionSort(isAscending: Boolean): List<Int> {
    val sortedList = mutableListOf<Int>()
    with(toMutableList()) {
        while(isNotEmpty()) {
            val itemIndex = if (isAscending) findMinIndex() else findMaxIndex()
            sortedList.add(removeAt(itemIndex))
        }
    }    
    return sortedList
}

println(numbers.selectionSortAscending())
println(numbers.selectionSortDescending())


