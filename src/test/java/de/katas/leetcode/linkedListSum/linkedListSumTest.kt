package linkedListSum

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.streams.toList

internal class linkedListSumTest {

    @Test
    fun addTwoNumbers() {
        val listOverhead: ListNode = generateListNode(342)

    }

    private fun generateListNode(number: Int): ListNode {
        val numberAsString = number.toString()
        val reversedNumberAsString = numberAsString.reversed()
        val listNode = ListNode(3)
        //reversedNumberAsString.chars().toList().fold

        return listNode
    }
}