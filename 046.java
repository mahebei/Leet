/*
46. Permutations

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

class Solution {
	public List<List<Integer>> gen(List<List<Integer>> res, List<Integer> item, int[] nums) {
		if (nums.length == 0) {
			res.add(new LinkedList<>(item));
		}
		for (int i = 0; i < nums.length; i++) {
			item.add(nums[i]);
			int[] next = new int[nums.length - 1];
			System.arraycopy(nums, 0, next, 0, i);
			System.arraycopy(nums, i + 1, next, i, next.length - i);
			gen(res, item, next);
			item.remove(item.size() - 1);
		}
		return res;
	}
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> item = new LinkedList<>();
		res = gen(res, item, nums);
		return res;
	}
}
