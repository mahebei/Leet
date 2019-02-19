/*
491. Increasing Subsequences
Medium

Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
*/

class Solution {
	public void addItems(Set<List<Integer>> res, List<Integer> item, int[] nums, int i) {
		if (i == nums.length) return;
		for (int j = i; j < nums.length; j++) {
			if (!item.isEmpty() && nums[j] < item.get(item.size() - 1)) continue;
			if (j != i && nums[j] == nums[j - 1]) continue;
			item.add(nums[j]);
			if (item.size() > 1) res.add(new ArrayList<>(item));
			addItems(res, item, nums, j + 1);
			item.remove(item.size() - 1);
		}
	}

	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		addItems(res, new ArrayList<>(), nums, 0);
		return new ArrayList<>(res);
	}
}
