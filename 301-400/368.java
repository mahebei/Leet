/*
368. Largest Divisible Subset
Medium

Given a set of distinct positive integers, 
find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/

class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if (nums.length == 0) return res;
		int[] count = new int[nums.length];
		int[] pre = new int[nums.length];
		int maxCount = 0, maxIn = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && count[j] >= count[i]) {
					count[i] = count[j] + 1;
					pre[i] = j;
				}
			}
			if (count[i] > maxCount) {
				maxCount = count[i];
				maxIn = i;
			}
		}
		for (int i = 0; i < maxCount; i++) {
			res.add(nums[maxIn]);
			maxIn = pre[maxIn];
		}
		return res;
	}
}
