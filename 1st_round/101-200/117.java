/*
117. Populating Next Right Pointers in Each Node II
Medium

Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) return;
		TreeLinkNode tem = root;
		if (root.left != null) {
			if (root.right != null) {
				root.left.next = root.right;
			}
			while (tem.next != null && root.left.next == null) {
				tem = tem.next;
				if (tem.left != null) {
					root.left.next = tem.left;
				} else if (tem.right != null) {
					root.left.next = tem.right;
				}
			}
		}
		if (root.right != null) {
			while (tem.next != null && root.right.next == null) {
				tem = tem.next;
				if (tem.left != null) {
					root.right.next = tem.left;
				} else if (tem.right != null) {
					root.right.next = tem.right;
				}
			}
		}
		connect(root.right); //MUST call right child first!
		connect(root.left);
	}
}
