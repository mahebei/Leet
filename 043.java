/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, 
also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
	public static String multiply(String num1, String num2) {
		int sums[] = new int[num1.length() + num2.length()];
		String res = "";
		if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
			return "0";
		}
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + sums[i + j + 1];
				sums[i + j + 1] = sum % 10;
				sums[i + j] += sum / 10;
			}
		}
		for (int i = 0; i < sums.length; i++) {
			if (sums[0] != 0 || i > 0) {
				res += sums[i];
			}
		}
		return res;
	}
}
