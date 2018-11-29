/*
114. Flatten Binary Tree to Linked List
Medium

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
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
	public TreeNode gernerate(TreeNode root, TreeNode pre){
		if (root == null) return pre;
		pre = gernerate(root.right, pre);
		pre = gernerate(root.left, pre);
		root.right = pre;
		root.left = null;
		return root;
	}
	public void flatten(TreeNode root) {
		gernerate(root, null);
	}
}
