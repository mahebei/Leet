/*
386. Lexicographical Numbers
Medium

Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/

class Solution {
	public static List<Integer> traverse(int n, int start, List<Integer> res) { 
		res.add(start);
		if (start * 10 <= n) traverse(n, start * 10, res);
		if (start > 9) {
			for (int i = 1; i <= 9; i++) {
				if (start + i <= n) res.add(start + i);
				if ((start + i) * 10 <= n) traverse(n, (start + i) * 10, res);
			}
		}
		return res;
	}

	public static List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= n && i <= 9; i++) {
			traverse(n, i, res);
		}
	return res;
	}
}
