/*
67. Add Binary
Easy

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

class Solution {
	public String addBinary(String a, String b) {
		String res = "";
		int carry = 0;
		int i = a.length() - 1;
		int j = b.length() - 1;
		while (i >= 0 && j >= 0) {
			res = (a.charAt(i) - '0' + b.charAt(j) - '0' + carry) % 2 + res;
			carry = (a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry) / 2;
		}
		while (i >= 0) {
			res = (a.charAt(i) - '0' + carry) % 2 + res;
			carry = (a.charAt(i--) - '0' + carry) / 2;
		}
		while (j >= 0) {
			res = (b.charAt(j) - '0' + carry) % 2 + res;
			carry = (b.charAt(j--) - '0' + carry) / 2;
		}
		if (carry == 1){
			res = '1' + res;
		}
		return res;
	}
}
