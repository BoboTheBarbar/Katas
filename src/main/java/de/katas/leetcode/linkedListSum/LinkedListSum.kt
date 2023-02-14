package linkedListSum

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class LinkedListSum {
    /**
     * @param l1 non empty linked list representing a non-negative integer
     * with digits in each node and in reversed order.
     * @param l2 is the same as l1.
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var digitSum: Int;
        val listOverhead: ListNode = ListNode(0)
        val totalSum: ListNode = ListNode(0)
        while(l1?.next != null || l2?.next != null) {
            digitSum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
        }
        return null
    }
}
