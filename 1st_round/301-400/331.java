/*
331. Verify Preorder Serialization of a Binary Tree
Medium

419

22

Favorite

Share
One way to serialize a binary tree is to use pre-order traversal. 
When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. 
Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:

Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
Example 2:

Input: "1,#"
Output: false
Example 3:

Input: "9,#,#,1"
Output: false
*/

class Solution {
	public boolean isValidSerialization(String preorder) {
		if (preorder.isEmpty()) return false;
		String[] ele = preorder.split(",");
		int index = 1, count;
		if (ele[0].charAt(0) != '#') {
			count = 1;
			index = 3;
		} else count = 0;
		while (count != 0 && ele.length >= index) {
			int pre = count;
			count = 0;
			for (int i = index - pre * 2; i < index; i++) {
				if (ele[i].charAt(0) != '#') count++;
			}
			index += count * 2;
		}
		return index == ele.length;
	}
}
