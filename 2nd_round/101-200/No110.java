package no001_100;

import java.util.Map;

public class No110 {
	public int getDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(getDepth(root.right), getDepth(root.left)) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
}
