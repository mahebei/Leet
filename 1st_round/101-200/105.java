/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
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
	public TreeNode build(int[] preorder, int[] inorder) {
		if (preorder.length == 0) return null;
		TreeNode root = new TreeNode(preorder[0]);
		if (preorder.length == 1) return root;
		int index = getRootIndex(inorder, root.val);
		root.left = build(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index));
		root.right = build(Arrays.copyOfRange(preorder, index + 1, preorder.length), Arrays.copyOfRange(inorder, index + 1, inorder.length));
		return root;
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder);
	}
}
