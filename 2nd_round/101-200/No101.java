package no001_100;

public class No101 {
	public boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null) {
			return q == null;
		} else if (q == null || p.val != q.val) return false;
		if (!isSymmetric(p.left, q.right)) return false;
		if (!isSymmetric(p.right, q.left)) return false;
		return true;
	}

	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root.left, root.right);
	}
}
