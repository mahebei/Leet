/*
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

class Solution {
	public List<List<Integer>> gen(List<List<Integer>> res, List<Integer> item, int[] nums) {
		if (nums.length == 0) {
			res.add(new LinkedList<>(item));
		}
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				item.add(nums[i]);
				int[] next = new int[nums.length - 1];
				System.arraycopy(nums, 0, next, 0, i);
				System.arraycopy(nums, i + 1, next, i, next.length - i);
				gen(res, item, next);
				item.remove(item.size() - 1);
			}
		}
		return res;
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> item = new LinkedList<>();
		Arrays.sort(nums);
		res = gen(res, item, nums);
		return res;
	}
}
