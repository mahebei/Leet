package no001_100;

public class No098 {
	long pre = (long) Integer.MIN_VALUE - 1;

	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		if (!isValidBST(root.left)) return false;
		if (root.val >= pre) return false;
		if (!isValidBST(root.right)) return false;
		return true;
	}
}
