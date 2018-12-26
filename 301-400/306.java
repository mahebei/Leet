/*
306. Additive Number
Medium

Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. 
Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true 
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true 
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199
Follow up:
How would you handle overflow for very large input integers?
*/

class Solution {
	public boolean check(String num, long a, long b) {
		if (num.length() == 0) return false;
		while (num.length() > 0) {
			long sum = a + b;
			if (num.startsWith(sum + "")) {
				a = b;
				b = sum;
				num = num.substring((sum + "").length());
			} else return false;
		}
		return true;
	}

	public boolean isAdditiveNumber(String num) {
		if (num.isEmpty()) return false;
		for (int i = 1; i <= num.length() / 2; i++) {
			if (num.charAt(0) == '0' && i > 1) break;
			for (int j = 1; j <= num.length() / 2; j++) {
				if (num.charAt(i) == '0' && j > 1) break;
				if (check(num.substring(i + j), Long.parseLong(num.substring(0, i)), Long.parseLong(num.substring(i, i + j))))
					return true;
			}
		}
		return false;
	}
}
