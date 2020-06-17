package com.xiao.algorithm.link

/**
 *
 * leetcode 2
 * 两数相加
 *
 * 执行用时 : 256 ms, 在所有 Kotlin 提交中击败了 57.87% 的用户
 * 内存消耗 : 40 MB, 在所有 Kotlin 提交中击败了 100.00% 的用户
 *
 * @author lix wang
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1 = l1
        var node2 = l2
        var listNode: ListNode? = null
        var currentNode: ListNode? = null

        var flag = false
        while (node1 != null || node2 != null) {
            val value1 = node1?.`val` ?: 0
            val value2 = node2?.`val` ?: 0
            var value = value1 + value2

            val currentValue = if (flag) {
                flag = false
                ++value % 10
            } else {
                value % 10
            }
            val newNode = ListNode(currentValue)
            if (listNode == null) {
                listNode = newNode
                currentNode = listNode
            } else {
                currentNode!!.next = newNode
                currentNode = newNode
            }

            if (value >= 10) {
                flag = true
            }

            node1 = node1?.next
            node2 = node2?.next
        }

        if (flag) {
            currentNode!!.next = ListNode(1)
        }
        return listNode
    }
}

fun main() {
    val listNode1 = ListNode(2)
    listNode1.next = ListNode(4)
    listNode1.next!!.next = ListNode(3)

    val listNode2 = ListNode(5)
    listNode2.next = ListNode(6)
    listNode2.next!!.next = ListNode(4)

    val obj = AddTwoNumbers()
    val result = obj.addTwoNumbers(listNode1, listNode2)
    println(result)
}