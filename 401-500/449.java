/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
	public StringBuilder preorder(TreeNode root, StringBuilder sb) {
		if (root == null) return sb;
		sb.append(',');
		sb.append(root.val);
		sb = (preorder(root.left, sb));
		sb = (preorder(root.right, sb));
		return sb;
	}

	// Encodes a tree to a single string.
	// Use preorder, for BST, preorder can determine a unique BST
	public String serialize(TreeNode root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		return preorder(root, sb).toString().substring(1);
	}

	public TreeNode insert(TreeNode root, int num) {
		if (root == null) return new TreeNode(num);
		if (num < root.val) root.left = insert(root.left, num);
		if (num > root.val) root.right = insert(root.right, num);
		return root;
	}

	// Decodes your encoded data to tree.
	// Use preorder output to rebuild a BST, just insert all elements 1 by 1 to the BST
	public TreeNode deserialize(String data) {
		if (data.isEmpty()) return null;
		Queue<Integer> q = new LinkedList<>();
		String[] strNums = data.split(",");
		for (String strNum : strNums) {
			q.offer(Integer.parseInt(strNum));
		}
		TreeNode tree = null;
		while (!q.isEmpty()) {
			tree = insert(tree, q.poll());
		}
		return tree;
	}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
