/*
327. Count of Range Sum
Hard

Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1], lower = -2, upper = 2,
Output: 3 
Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
*/

class Solution {
	public static int sortAndCount(long[] sums, int l, int r, int lower, int upper) {
		if (r <= l + 1) return 0;
		int m = (l + r) / 2;
		int count = sortAndCount(sums, l, m, lower, upper) + sortAndCount(sums, m, r, lower, upper);
		long[] tem = new long[r - l];
		int j = m, k = m, indexR = m, indexL = l, indexTem = 0;
		while (indexL < m) {
			// Compare between left and right halves.
			while (k < r && sums[k] - sums[indexL] < lower) k++;
			while (j < r && sums[j] - sums[indexL] <= upper) j++;
			while (indexR < r && sums[indexR] < sums[indexL]) tem[indexTem++] = sums[indexR++];
			tem[indexTem++] = sums[indexL++];
			count += j - k;
		}
		System.arraycopy(tem, 0, sums, l, indexR - l);
		return count;
	}

	public static int countRangeSum(int[] nums, int lower, int upper) {
		long[] sums = new long[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		return sortAndCount(sums, 0, sums.length, lower, upper);
	}
}
