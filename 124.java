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
	int max = Integer.MIN_VALUE;
	public int getMaxPath(TreeNode root) {
		if (root == null) return 0;
		int left = Math.max(0, getMaxPath(root.left));
		int right = Math.max(0, getMaxPath(root.right));
		max = Math.max(max, left + root.val + right);
		return root.val + Math.max(left, right);
	}
	public int maxPathSum(TreeNode root) {
		getMaxPath(root);
		return max;
	}
}
