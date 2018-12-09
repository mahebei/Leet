/*
168. Excel Sheet Column Title
Easy

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
*/

class Solution {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		int mod;
		while (n > 0) {
			mod = n % 26 - 1;
			if (mod == -1) {
				mod = 25;
				n--;
			}
			sb.insert(0, (char) ('A' + mod));
			n /= 26;
		}
		return sb.toString();
	}
}
