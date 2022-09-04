import kotlin.math.max

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTree {
    companion object {
        fun longestConsecutive(root: TreeNode?): Int {
            if (root != null) {
                val currentStreak: Int = 1
                val longestLeftConsecutive = searchLongestStreak(root.left, root.`val`, currentStreak, currentStreak)
                val longestRightConsecutive = searchLongestStreak(root.right, root.`val`, currentStreak, currentStreak)
                return max(longestLeftConsecutive, longestRightConsecutive)
            } else {
                return 0
            }
        }

        private fun searchLongestStreak(node: TreeNode?, lastValue: Int, currentStreak: Int, longestStreak: Int): Int {
            if (node != null) {
                val newStreak = calcCurrentStreak(currentStreak, node.`val`, lastValue)
                val newLongestStreak = max(newStreak, longestStreak)

                val pathLeft = searchLongestStreak(node.left, node.`val`, newStreak, newLongestStreak)
                val pathRight = searchLongestStreak(node.right, node.`val`, newStreak, newLongestStreak)
                return max(pathLeft, pathRight)
            } else {
                return longestStreak
            }

        }

        private fun calcCurrentStreak(currentStreak: Int, currentValue: Int, lastValue: Int): Int {
            return if (currentValue.isIncrementtOf(lastValue)) currentStreak + 1 else 1
        }
    }
}

//fun Int.isDecrementOf(value: Int) : Boolean = (this == value - 1)
fun Int.isIncrementtOf(value: Int): Boolean = (this == value + 1)
