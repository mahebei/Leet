/*
107. Binary Tree Level Order Traversal II
Easy

Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
		if (res.size() <= level && (root.left != null || root.right != null))
			res.add(0, new LinkedList<>());
		if (root.left != null) {
			res.get(res.size() - level - 1).add(root.left.val);
			traverse(root.left, level + 1, res);
		}
		if (root.right != null) {
			res.get(res.size() - level - 1).add(root.right.val);
			traverse(root.right, level + 1, res);
		}
		return res;
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) return res;
		List<Integer> item = new LinkedList<>();
		item.add(root.val);
		res.add(item);
		res = traverse(root, 1, res);
		return res;
	}
}
