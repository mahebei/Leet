/*
222. Count Complete Tree Nodes
Medium

Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	public int getHeight(TreeNode root) {
		int height = 0;
		while (root != null) {
			height++;
			root = root.left;
		}
		return height;
	}

	public int countNodes(TreeNode root) {
		int height = getHeight(root);
		if (height == 0) return 0;
		// If the height of left and right tree same, that is the root's left tree is full.
		// The num of nodes in left tree is 2^(height-1), including the root. Continue to count the right tree.
		if (height == getHeight(root.right) + 1) return (int) Math.pow(2, height - 1) + countNodes(root.right);
		// If not same, the ending node is in left tree, so the right is full (height is 1 less).
		// The num of nodes in right tree is 2^(height-2), including the root. Continue to count the left tree.
		else return (int) Math.pow(2, height - 2) + countNodes(root.left);
	}
}
