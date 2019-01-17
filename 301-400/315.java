/*
315. Count of Smaller Numbers After Self
Hard

You are given an integer array nums and you have to return a new counts array.
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
*/

class Solution {
	class Tree {
		Tree left, right;
		int val, sum, dup = 1;

		public Tree(int v, int s) {
			val = v;
			sum = s;
		}
	}

	public Tree findPos(Tree root, Integer[] res, int i, int num, int pre) {
		if (root == null) {
			root = new Tree(num, 0);
			res[i] = pre;
		} else if (num == root.val) {
			root.dup++;
			res[i] = pre + root.sum;
		} else if (num < root.val) {
			root.sum++;
			root.left = findPos(root.left, res, i, num, pre);
		} else {
			root.right = findPos(root.right, res, i, num, pre + root.sum + root.dup);
		}
		return root;
	}

	public List<Integer> countSmaller(int[] nums) {
		Integer[] res = new Integer[nums.length];
		Tree root = null;
		for (int i = nums.length - 1; i >= 0; i--) {
			root = findPos(root, res, i, nums[i], 0);
		}
		return Arrays.asList(res);
	}
}
