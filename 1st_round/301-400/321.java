/*
321. Create Maximum Number
Hard

Given two arrays of length m and n with digits 0-9 representing two numbers. 
Create the maximum number of length k <= m + n from digits of the two. 
The relative order of the digits from the same array must be preserved. Return an array of the k digits.

Note: You should try to optimize your time and space complexity.

Example 1:

Input:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output:
[9, 8, 6, 5, 3]
Example 2:

Input:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
Output:
[6, 7, 6, 0, 4]
Example 3:

Input:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
Output:
[9, 8, 9]
*/

class Solution {
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] res = new int[k];
		for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
			int[] arr1 = getKMax(nums1, i);
			int[] arr2 = getKMax(nums2, k - i);
			int[] curr = new int[k];
			int index1 = 0, index2 = 0, indexCurr = 0;
			while (index1 < arr1.length && index2 < arr2.length) {
				if (compare(arr1, index1, arr2, index2)) {
					curr[indexCurr++] = arr1[index1++];
				} else {
					curr[indexCurr++] = arr2[index2++];
				}
			}
			while (index1 < arr1.length) curr[indexCurr++] = arr1[index1++];
			while (index2 < arr2.length) curr[indexCurr++] = arr2[index2++];
			if (compare(curr, 0, res, 0)) res = curr;
		}
		return res;
	}

	public boolean compare(int[] nums1, int i, int[] nums2, int j) {
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j]) return true;
			if (nums1[i] < nums2[j]) return false;
			i++;
			j++;
		}
		return i != nums1.length;
	}

	public int[] getKMax(int[] nums, int k) {
		int[] res = new int[k];
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
				len--;
			}
			if (len < k) res[len++] = nums[i];
		}
		return res;
	}
}
