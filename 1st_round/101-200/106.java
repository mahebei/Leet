/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
	public int getRootIndex(int[] inorder, int val) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == val) return i;
		}
		return -1;
	}
	public TreeNode build(int[] inorder, int[] postorder) {
		if (inorder.length == 0) return null;
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		if (inorder.length == 1) return root;
		int index = getRootIndex(inorder, root.val);
		root.right = build(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postorder, index, postorder.length - 1));
		root.left = build(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postorder, 0, index));
		return root;
	}
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return build(inorder, postorder);
	}
}
