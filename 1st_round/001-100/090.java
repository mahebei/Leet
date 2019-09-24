/*
90. Subsets II
Medium

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

class Solution {
	public List<List<Integer>> getSubsets(int[] nums,int i, List<List<Integer>> res, List<Integer> subset) {
		for (; i < nums.length; i++) {
			subset.add(nums[i]);
			if (!res.contains(subset)) {
				res.add(new LinkedList<>(subset));
				getSubsets(nums, i + 1, res, subset);
			}
			subset.remove(subset.size() - 1);
		}
		return res;
	}
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		if (nums.length > 0) {
			Arrays.sort(nums);
			res = getSubsets(nums, 0, new LinkedList<>(), new LinkedList<>());
		}
		res.add(new LinkedList<>());
		return res;
	}
}
