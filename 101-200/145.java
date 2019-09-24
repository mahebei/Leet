/*
145. Binary Tree Postorder Traversal
Hard

Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?
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
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		if (root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		root = root.left;
		TreeNode pre = new TreeNode(0);
		while (!stack.isEmpty()) {
			while (root != null && pre != root) {
				stack.add(root);
				root = root.left;
			}
			root = stack.peek();
			if (root.right == null || pre == root.right) {
				res.add(root.val);
				stack.pop();
				if (pre != root.right) {
					pre = root;
					root = root.right;
				} else {
					pre = root;
				}
			} else {
				root = root.right;
			}
		}
		return res;
	}
}
