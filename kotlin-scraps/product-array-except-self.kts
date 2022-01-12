#!/usr/bin/env kotlin

fun productExceptSelf(nums: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (indexA in 0 until nums.size) {
            var acc = 1
            for (indexB in 0 until nums.size) {
                if (indexB != indexA) {
                    println("indexB = $indexB")
                    println("value = ${nums[indexB]}")
                    acc = acc * nums[indexB]
                }
            }
            result.add(acc)
        }
        return result.toIntArray()
    }

val nums1 = intArrayOf(1,2,3,4)
println("Result: ${productExceptSelf(nums1).toList()}")
println("Is Correct: ${productExceptSelf(nums1) == intArrayOf(24,12,8,6)}")