/*
307. Range Sum Query - Mutable
Medium

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

class NumArray {

	int[] tree;

	public void buildTree(int[] nums, int l, int r, int curr) {
		if (l == r - 1) {
			tree[curr] = nums[l];
			return;
		}
		buildTree(nums, l, (l + r) / 2, curr * 2 + 1);
		buildTree(nums, (l + r) / 2, r, curr * 2 + 2);
		tree[curr] = tree[curr * 2 + 1] + tree[curr * 2 + 2];
	}

	public NumArray(int[] nums) {
		if (nums.length > 0) {
			tree = new int[nums.length * 4];
			buildTree(nums, 0, nums.length, 0);
		}
	}

	public void update(int i, int val) {
		int l = 0, r = tree.length / 4, curr = 0;
		while (l < r - 1) {
			int m = (l + r) / 2;
			if (m <= i) {
				l = m;
				curr = curr * 2 + 2;
			} else {
				r = m;
				curr = curr * 2 + 1;
			}
		}
		tree[curr] = val;
		while (curr > 0) {
			curr = (curr - 1) / 2;
			tree[curr] = tree[curr * 2 + 1] + tree[curr * 2 + 2];
		}
	}

	public int search(int i, int j, int l, int r, int curr) {
		if (i == l && j == r - 1) return tree[curr];
		int m = (l + r) / 2;
		if (j < m) return search(i, j, l, m, curr * 2 + 1);
		if (i >= m) return search(i, j, m, r, curr * 2 + 2);
		else return search(i, m - 1, l, m, curr * 2 + 1) + search(m, j, m, r, curr * 2 + 2);
	}

	public int sumRange(int i, int j) {
		return search(i, j, 0, tree.length / 4, 0);
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
