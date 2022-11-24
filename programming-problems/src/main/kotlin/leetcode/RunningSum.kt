package leetcode

import kotlin.system.measureTimeMillis

// Implement a running sum
// The result is an result array in which for each element equals to the summ of all
// element from inputArray[0] until inputArray[i]
// input: an array
// output: another array with the running sum for each element
// examples:
// input: [1, 1, 1, 1] output: [1, 2, 3, 4]
// input: [0, 0, 0, 0] output: [0, 0, 0, 0]
// input: [ ] output: [ ]
// input: [1,2,3,4] output [1,3,6,10]

val cases = mapOf(
    intArrayOf(1, 1, 1, 1) to intArrayOf(1, 2, 3, 4),
    intArrayOf(0, 0, 0, 0) to intArrayOf(0, 0, 0, 0),
    intArrayOf(1, 2, 3, 4) to intArrayOf(1, 3, 6, 10),
)

fun main() {
    for ((input, output) in cases) {
        var result: IntArray? = null
        val elapsedTime = measureTimeMillis {
            result = runningSum(input)
        }
        if (true == result?.contentEquals(output)) {
            println("PASS - $elapsedTime: input: ${input.toList()} | output: ${output.toList()}")
        } else {
            println("FAILED - $elapsedTime: input: ${input.toList()} | result: ${result?.toList()} | output: ${output.toList()}")
        }
    }
}

fun runningSum(nums: IntArray): IntArray {
    return thirdTry(nums)
}

fun thirdTry(nums: IntArray): IntArray {
    return nums.runningReduce { acc, value -> acc + value }.toIntArray()
}

fun secondTry(nums: IntArray): IntArray {
    // How to use the accumulated values to reduce the execution time?
    val outputList = mutableListOf<Int>()
    for (index in nums.indices) {
        if (index == 0) {
            outputList.add(nums[index])
        } else {
            outputList.add(outputList[index-1] + nums[index])
        }
    }
    return outputList.toIntArray()
}

fun firstTry(nums: IntArray): IntArray {
    val outputList = mutableListOf<Int>()
    for (index in nums.indices) {
        var acc = 0
        for (runningIndex in 0..index) {
            acc += nums[runningIndex]
        }
        outputList.add(acc)
    }
    return outputList.toIntArray()
}
