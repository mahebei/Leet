/*
128. Longest Consecutive Sequence
Hard

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

class Solution {
	public int longestConsecutive(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				int lo = 0;
				if (map.containsKey(nums[i] - 1)) {
					lo = map.get(nums[i] - 1);
				}
				int hi = 0;
				if (map.containsKey(nums[i] + 1)) {
					hi = map.get(nums[i] + 1);
				}
				int sum = lo + 1 + hi;
				map.put(nums[i], sum);
				res = Math.max(sum, res);
				map.put(nums[i] - lo, sum);
				map.put(nums[i] + hi, sum);
			}
		}
		return res;
	}
}
