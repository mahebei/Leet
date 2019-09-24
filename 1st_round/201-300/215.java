/*
215. Kth Largest Element in an Array
Medium

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
	public int par(int[] nums, int l, int r) {
		int pivot = l;
		for (int i = l + 1; i < r; i++) {
			if (nums[i] > nums[pivot]) {
				int tem = nums[i];
				nums[i] = nums[pivot];
				nums[pivot] = tem;
			}
		}
		return pivot;
	}

	public int findKthLargest(int[] nums, int k) {
		int i = 0, j = nums.length;
		while (i < j - 1) {
			int pivot = par(nums, i, j);
			if (pivot == k - 1) return nums[pivot];
			if (pivot > k - 1) j = pivot;
			else i = pivot + 1;
		}
		return nums[k - 1];
	}
}
