package com.xiao.algorithm.slide_window

/**
 * leetcode 3
 * 无重复字符的最长子串
 *
 * 滑动窗口问题
 * abcabcbb 无重复字符最长子串为3
 *
 * 执行用时 : 216 ms, 在所有 Kotlin 提交中击败了 97.89% 的用户
 * 内存消耗 : 33.9 MB, 在所有 Kotlin 提交中击败了 100.00% 的用户
 *
 * @author lix wang
 */
class LengthOfLongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        val map = HashMap<Char, Int>()
        var left = 0
        for (index in s.indices) {
            map[s[index]]?.let {
                left = left.coerceAtLeast(it + 1)
            }
            map[s[index]] = index
            max = max.coerceAtLeast(index - left + 1)
        }
        return max
    }
}

fun main() {
    println(LengthOfLongestSubstring().lengthOfLongestSubstring("abba"))
}