package longestConsecutivePathInBinaryTree

import BinaryTree
import TreeNode
import isIncrementtOf
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BinaryTreeTest {

    @Test
    fun isDecrementOf() {
        assert(5.isIncrementtOf(4))
    }

    @Test
    fun increment() {
        val currentStreak = 1
        val actualStreak = if (5.isIncrementtOf(4)) currentStreak + 1 else 1
        assertEquals(actualStreak, 2)
    }

    @Test
    fun longestConsecutive() {
//        val treeValues = listOf(1, null, 3, 2, 4, null, null, null, 5)

        val rootNode = createDummyTree()
        val longestConsecutive = BinaryTree.longestConsecutive(rootNode)
        assertEquals(4, longestConsecutive)
    }

    private fun createDummyTree(): TreeNode {
        val root = TreeNode(1)
        root.left = null
        root.right = TreeNode(3)

        root.right?.left = TreeNode(2)
        root.right?.right = TreeNode(4)

        root.right?.left?.left = null
        root.right?.left?.right = null

        root.right?.right?.left = null
        root.right?.right?.right = TreeNode(5)

        root.right?.right?.right?.left = TreeNode(4)
        root.right?.right?.right?.right = TreeNode(6)

        return root
    }

    private fun createDummyTree(treeValues: List<Int?>, currentNode: TreeNode?): TreeNode? {
        if(currentNode != null) {
            currentNode.left = treeValues[1]?.let(moveNextValueToTreeNode(treeValues))
            currentNode.right = treeValues[2]?.let(moveNextValueToTreeNode(treeValues))
        }

        return currentNode
    }

    private fun moveNextValueToTreeNode(treeValues: List<Int?>): (Int) -> TreeNode? = {
        val newCurrentNode = TreeNode(it)
        treeValues.drop(1)
        createDummyTree(treeValues, newCurrentNode)
    }
}