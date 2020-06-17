package com.xiao.algorithm.hash

/**
 * leetcode 1
 *
 * 两数之和
 *
 * 执行用时 : 220 ms, 在所有 Kotlin 提交中击败了 79.80% 的用户
 * 内存消耗 : 34.8 MB, 在所有 Kotlin 提交中击败了 100.00% 的用户
 *
 * @author lix wang
 */
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hash = mutableMapOf<Int, Int>()
        val intArray = IntArray(2)
        for (index in nums.indices) {
            val value = nums[index]
            val hashIndex = hash[target - value]
            if (hashIndex != null) {
                intArray[0] = hashIndex
                intArray[1] = index
                break
            } else {
                hash[value] = index
            }
        }
        return intArray
    }
}

fun main() {
    val intArray = TwoSum().twoSum(listOf(2, 7, 11, 15).toIntArray(), 9)
    println("${intArray[0]} ${intArray[1]}")
}