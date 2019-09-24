/*
98. Validate Binary Search Tree
Medium

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
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
	public List<Integer> inorder(TreeNode root, List<Integer> list) {
		if (root == null) return list;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
		return list;
	}
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new LinkedList<>();
		inorder(root, list);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1)) return false;
		}
		return true;
	}
}
