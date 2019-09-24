/*
113. Path Sum II
Medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
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
	public List<List<Integer>> getPath(TreeNode root, int sum, List<List<Integer>> res, List<Integer> item) {
		sum -= root.val;
		item.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == 0) res.add(new LinkedList<>(item));
			item.remove(item.size() - 1);
			return res;
		}
		if (root.left != null) res = getPath(root.left, sum, res, item);
		if (root.right != null) res = getPath(root.right, sum, res, item);
		item.remove(item.size() - 1);
		return res;
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<>();
		if (root == null) return res;
		getPath(root, sum, res, new LinkedList<>());
		return res;
	}
}
