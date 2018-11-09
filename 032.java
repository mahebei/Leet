/*
Given a string containing just the characters '(' and ')', 
find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/

class Solution {
	public int longestValidParentheses(String s) {
		int res = 0, diff = 0;
		int memo[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				diff++;
			} else if (diff > 0) {
				memo[i] = memo[i - 1] + 2;
				if (i > memo[i]) {
					memo[i] += memo[i - memo[i]];
				}
				if (memo[i] > res) {
					res = memo[i];
				}
				diff--;
			}
		}
		return res;
	}
}
