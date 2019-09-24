package no001_100;

import java.util.*;

public class No106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0) return null;
		TreeNode newNode = new TreeNode(postorder[postorder.length - 1]);
		int curr = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length-1]){
				curr = i;
				break;
			}
		}
		newNode.left = buildTree(Arrays.copyOfRange(inorder, 0, curr),
				Arrays.copyOfRange(postorder, 0, curr));
		newNode.right = buildTree(Arrays.copyOfRange(inorder, curr + 1, inorder.length),
				Arrays.copyOfRange(postorder, curr, inorder.length - 1));
		return newNode;
	}
}
