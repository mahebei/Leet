package no001_100;

import java.util.*;

public class No095 {
	public List<TreeNode> generateTrees(int s, int e) {
		List<TreeNode> res = new ArrayList<>();
		if (s > e) {
			res.add(null);
			return res;
		}
		for (int i = s; i <= e; i++) {
			List<TreeNode> left = generateTrees(s, i - 1);
			List<TreeNode> right = generateTrees(i + 1, e);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode curr = new TreeNode(i);
					curr.left = l;
					curr.right = r;
					res.add(curr);
				}
			}
		}
		return res;
	}

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) return new ArrayList<>();
		return generateTrees(1, n);
	}
}
