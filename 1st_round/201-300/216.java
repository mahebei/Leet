/*
216. Combination Sum III
Medium

Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

class Solution {
	public void getCombinations(int k, int n, List<List<Integer>> res, List<Integer> item, int i) {
		if (k == 0 && n == 0) res.add(new LinkedList<>(item));
		if (!(k > 0 && n > 0)) {
			return;
		}
		for (; i <= 10 - k; i++) {
			item.add(i);
			getCombinations(k - 1, n - i, res, item, i + 1);
			item.remove(item.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new LinkedList<>();
		if ((1 + k) * k / 2 > n || (19 - k) * k / 2 < n) return res;
		getCombinations(k, n, res, new LinkedList<>(), 1);
		return res;
	}
}
