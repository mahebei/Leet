package no001_100;

public class No100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null) {
			return q == null;
		} else if (q == null || p.val != q.val) return false;
		if (!isSameTree(p.left, q.left)) return false;
		if (!isSameTree(p.right, q.right)) return false;
		return true;
	}
}
