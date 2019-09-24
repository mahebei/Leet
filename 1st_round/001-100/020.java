/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

class Solution {
	public boolean isValid(String s) {
		String p = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				p += ch;
			} else if (p.length() == 0
					|| (ch == ')' && p.charAt(p.length() - 1) != '(')
					|| (ch == ']' && p.charAt(p.length() - 1) != '[')
					|| (ch == '}' && p.charAt(p.length() - 1) != '{')) {
				return false;
			} else if (p.length() > 0) {
				p = p.substring(0, p.length() - 1);
			}
		}
		return p.isEmpty();
	}
}
