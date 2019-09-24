/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
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
	public List<Integer> inorder(TreeNode root, List<Integer> res) {
		if (root != null) {
			inorder(root.left, res);
			res.add(root.val);
			inorder(root.right, res);
		}
		return res;
	}
	public List<Integer> inorderTraversal(TreeNode root) {
		//return inorder(root, new LinkedList<>());
		List<Integer> res = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null){
				stack.add(root);
				root = root.left;
			}
			res.add(stack.peek().val);
			root = stack.pop().right;
		}
		return res;
	}
}
