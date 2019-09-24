/*
77. Combinations
Medium

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
	public List<List<Integer>> makeCombinations(List<List<Integer>> res, List<Integer> newList, int start, int n, int k) {
		if (k == 0) {
			res.add(new LinkedList<>(newList));
			return res;
		}
		for (int i = start; i < n - k + 2; i++) {
			newList.add(i);
			res = makeCombinations(res, newList, i + 1, n, k - 1);
			newList.remove(newList.size() - 1);
		}
		return res;
	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<>();
		return makeCombinations(res, new LinkedList<>(), 1, n, k);
	}
}
