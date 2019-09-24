/*
227. Basic Calculator II
Medium

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

class Solution {
	public int calculate(String s) {
		int num = 0;
		char pre = '+';
		Stack<Integer> nums = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			while (i < s.length() - 1 && s.charAt(i) == ' ') i++;
			if (Character.isDigit(s.charAt(i))) {
				num = s.charAt(i) - '0';
				while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
					i++;
					num = num * 10 + s.charAt(i) - '0';
				}
				if (pre == '-') num = -num;
				else if (pre == '*') {
					num *= nums.pop();
				} else if (pre == '/') {
					num = nums.pop() / num;
				}
			}
			i++;
			while (i < s.length() - 1 && s.charAt(i) == ' ') i++;
			if (i < s.length() - 1) {
				pre = s.charAt(i);
				nums.push(num);
			}
		}
		nums.push(num);
		int sum = 0;
		while (!nums.isEmpty()) sum += nums.pop();
		return sum;
	}
}
