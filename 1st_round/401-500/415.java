/*
415. Add Strings
Easy

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
	public String addStrings(String num1, String num2) {
		int carry = 0;
		String res = "";
		int i = num1.length() - 1, j = num2.length() - 1;
		while (i >= 0 || j >= 0 || carry == 1) {
			int curr = carry;
			curr += (i >= 0) ? num1.charAt(i) - '0' : 0;
			curr += (j >= 0) ? num2.charAt(j) - '0' : 0;
			res = curr % 10 + res;
			carry = curr / 10;
			i--;
			j--;
		}
		return res;
	}
}
