/*
301. Remove Invalid Parentheses
Hard

Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
*/

class Solution {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new LinkedList<>();
		remove(s, 0, 0, new char[]{'(', ')'}, res);
		return res;
	}

	public void remove(String s, int i, int pre, char[] par, List<String> res) {
		int bal = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) == par[0]) bal++;
			if (s.charAt(i) == par[1]) bal--;
			if (bal >= 0) continue;
			for (int j = pre; j <= i; j++) {
				if (s.charAt(j) == par[1] && (j == pre || s.charAt(j - 1) != par[1])) {
					remove(s.substring(0, j) + s.substring(j + 1), i, j, par, res);
				}
			}
			return;
		}
		String rev = new StringBuilder(s).reverse().toString();
		if (par[0] =='(') remove(rev,0,0,new char[]{')', '('}, res);
		else res.add(rev);
	}
}
