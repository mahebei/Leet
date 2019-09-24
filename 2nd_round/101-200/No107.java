package no001_100;

import java.util.*;

public class No107 {
	List<List<Integer>> res = new ArrayList<>();

	public void levelOrderBottom(TreeNode root, int level) {
		if (root == null) return;
		if (res.size() < level) {
			res.add(0, new ArrayList<>());
		}
		res.get(res.size() - level).add(root.val);
		levelOrderBottom(root.left, level+1);
		levelOrderBottom(root.right, level+1);
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		levelOrderBottom(root, 1);
		return res;
	}
}
