package no001_100;

import java.util.*;

public class No094 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}
}
