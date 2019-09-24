package no001_100;

public class No099 {
	TreeNode preNode = null;
	TreeNode first = null;
	TreeNode second = null;

	public void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		if (preNode != null && root.val < preNode.val) {
			second = root;
			if (first == null) first = preNode;
		}
		preNode = root;
		inorder(root.right);
	}

	public void recoverTree(TreeNode root) {
		inorder(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
}
