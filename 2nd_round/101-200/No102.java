package no001_100;

import java.util.*;

public class No102 {
	List<List<Integer>> res = new ArrayList<>();

	public void levelOrder(TreeNode root, int level) {
		if (root == null) return;
		if (res.size() == level) res.add(new ArrayList<>());
		res.get(level).add(root.val);
		levelOrder(root.left, level + 1);
		levelOrder(root.right, level + 1);
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		levelOrder(root, 0);
		return res;
	}
}
