/*
199. Binary Tree Right Side View
Medium

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
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
	public List<Integer> traverse(TreeNode root, int level, List<Integer> res) {
		if (root == null) return res;
		if (res.size() == level) res.add(0);
		res.remove(level);
		res.add(level, root.val);
		res = traverse(root.left, level + 1, res);
		res = traverse(root.right, level + 1, res);
        return res;
	}

	public List<Integer> rightSideView(TreeNode root) {
		//List<Integer> res = new LinkedList<>();
		return traverse(root, 0, new LinkedList<>());
	}
}
