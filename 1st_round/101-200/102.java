/*
102. Binary Tree Level Order Traversal
Medium

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
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
	public List<List<Integer>> traverse(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null) return res;
		if (res.size() <= level && (root.left != null || root.right != null)) res.add(new LinkedList<>());
		if (root.left != null) {
			res.get(level).add(root.left.val);
			res = traverse(root.left, level + 1, res);
		}
		if (root.right != null) {
			res.get(level).add(root.right.val);
			res = traverse(root.right, level + 1, res);
		}
		return res;
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) return res;
		List<Integer> item = new LinkedList<>();
		item.add(root.val);
		res.add(new LinkedList<>(item));
		traverse(root, 1, res);
		return res;
	}
}
