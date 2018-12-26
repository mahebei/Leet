/*
300. Longest Increasing Subsequence
Medium

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/

/*
The memo is to keep an array of smallest increasing nums.
input: [0, 8, 4, 12, 2]
memo: [0], [0, 8], [0, 4], [0, 4, 12], [0 , 2, 12]
Traverse the array, for each element, if it's bigger than last element in memo, add it in memo, len++,
									else find the smallest element of the nums which are bigger than it, replace it.
memo may not the longest increasing subsequence, but the len are equal.

*/
class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;
		int[] memo = new int[nums.length];
		memo[0] = nums[0];
		int len = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > memo[len - 1]) {
				memo[len++] = nums[i];
			} else {
				int index = Arrays.binarySearch(memo, 0, len, nums[i]);
				if (index < 0) index = -index - 1;
				memo[index] = nums[i];
			}
		}
		return len;
	}
}
