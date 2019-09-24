/*
78. Subsets
Medium

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
	public List<List<Integer>> getSubsets(List<List<Integer>> res, List<Integer> subset, int[] nums, int i) {
		if (i == nums.length) {
			return res;
		}
		for (; i < nums.length; i++) {
			subset.add(nums[i]);
			res.add(new LinkedList<>(subset));
			res = getSubsets(res, subset, nums, i + 1);
			subset.remove(subset.size() - 1);
		}
		return res;
	}
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		res = getSubsets(res, new LinkedList<>(), nums, 0);
		res.add(new LinkedList<>());
		return res;
	}
}
