/*
257. Binary Tree Paths
Easy

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
	public void traverse(TreeNode root, String path, List<String> res) {
		if (root.left == null && root.right == null) {
			path += root.val;
			res.add(path);
			return;
		}
		path += root.val + "->";
		if (root.left != null) traverse(root.left, path, res);
		if (root.right != null) traverse(root.right, path, res);
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new LinkedList<>();
		if (root != null) {
			traverse(root, "", res);
		}
		return res;
	}
}
