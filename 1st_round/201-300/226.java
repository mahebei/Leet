/*
226. Invert Binary Tree
Easy

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
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
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode tem = root.left;
		root.left = root.right;
		root.right = tem;
		if (root.left != null) invertTree(root.left);
		if (root.right != null) invertTree(root.right);
		return root;
	}
}
