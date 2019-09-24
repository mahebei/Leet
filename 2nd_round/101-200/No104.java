package no001_100;

public class No104 {
	int depth = 0;

	public void maxDepth(TreeNode root, int currDepth) {
		if (root == null) return;
		currDepth++;
		depth = Math.max(depth, currDepth);
		maxDepth(root.left, currDepth);
		maxDepth(root.right, currDepth);
	}

	public int maxDepth(TreeNode root) {
		maxDepth(root, 0);
		return depth;
	}
}
