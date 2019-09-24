/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
	public void addParenthesis(int n, List<String> res, int l, int r,
			String str) {
		if (l + r == n * 2) {
			res.add(str);
			return;
		}
		if (l < n) {
			addParenthesis(n, res, l + 1, r, str + '(');
		}
		if (l > r) {
			addParenthesis(n, res, l, r + 1, str + ')');
		}
	}
	public List<String> generateParenthesis(int n) {
		List<String> res = new LinkedList<String>();
		if (n > 0) {
			addParenthesis(n, res, 0, 0, "");
		}
		return res;
	}
}
