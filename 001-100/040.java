/*
40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target), 
find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

class Solution {
	public List<List<Integer>> check(int[] candidates, int target, List<List<Integer>> res, List<Integer> item) {
		if (target == 0) {
			res.add(new LinkedList<>(item));
		} else {
			for (int i = 0; i < candidates.length; i++) {
				if (i == 0 || candidates[i] != candidates[i - 1]) {
					target -= candidates[i];
					if (target >= 0) {
						item.add(candidates[i]);
						check(Arrays.copyOfRange(candidates, i + 1, candidates.length), target, res, item);
						target += candidates[i];
					} else {
						break;
					}
				}
			}
		}
		if (!item.isEmpty()) {
			item.remove(item.size() - 1);
		}
		return res;
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new LinkedList<>();
		res = check(candidates, target, res, new LinkedList<>());
		return res;
	}
}
