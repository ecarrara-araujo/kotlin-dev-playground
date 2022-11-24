package hackerrank

// input: array with 5 positive integers
// output: prints min and max sum values calculated with only 4 of the 5 numbers in a single line separated by one space

// Examples
// Input: [1, 1, 1, 1, 1] Output: 4 4
// Input: [0, 0, 0, 0, 0] Output: 0 0
// Input: [1, 2, 3, 4, 5] Output: 10 14
// Input: [10, 9, 8, 7, 6] Output: 30 34
// Input: [1, 2, 1, 2, 3] Output: 6 8

// Using 4 of the 5 implies not summing the same value with itself.
// iterate through the array
// exclude the current number and use the sum of the other 4

// fun minMaxSum(arr: Array<Int>): Unit // result goes to output
//     set resultingSums to empty list
//     for each number in arr
//         set sumAccumulator to 0
//         for each numberToSum in arr
//            if numberToSum index != number index
//                sumAccumulator += numberToSum
//         end for
//         add sumAccumulator to resultingSums
//.    end for
//     sort resultingSums
//     print resultingSums.first resultingSums.last

//                     *
// Input: [1, 2, 3, 4, 5] Output: 10 14
// resultingSums: [14, 13, 12, 11, 10] sumAccumulator: 0
// resultingSums Sorted: [10,11,12,13,14]
// prints: 10 14

fun main() {
//    miniMaxSum(arrayOf(0, 0, 0, 0, 0))
//    miniMaxSum(arrayOf(1, 1, 1, 1, 1))
//    miniMaxSum(arrayOf(1, 2, 3, 4, 5))
//    miniMaxSum(arrayOf(10, 9, 8, 7, 6))
//    miniMaxSum(arrayOf(1, 2, 1, 2, 3))
    miniMaxSum(arrayOf(256741038, 623958417, 467905213, 714532089, 938071625)) // 2063136757 2744467344
}

fun miniMaxSum(arr: Array<Int>) {
    val sums = mutableListOf<Long>()
    for (pivotIndex in arr.indices) {
        var currentSum: Long = 0
        for ((runningIndex, number) in arr.withIndex()) {
            if (runningIndex != pivotIndex) {
                currentSum += number
                println("currentSum: $currentSum")
            }
        }
        sums.add(currentSum)
    }
    val ordered = sums.sorted()
    if (ordered.isNotEmpty()) {
        println("${ordered.first()} ${ordered.last()}")
    }
}