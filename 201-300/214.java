/*
214. Shortest Palindrome
Hard

Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:
Input: "aacecaaa"
Output: "aaacecaaa"


Example 2:
Input: "abcd"
Output: "dcbabcd"
*/

class Solution {
	//https://leetcode.com/problems/shortest-palindrome/discuss/60113/Clean-KMP-solution-with-super-detailed-explanation
	public int getKMP(String s) {
		int[] table = new int[s.length()];
		int index = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(index)) {
				table[i] = table[i - 1] + 1;
				index++;
			} else {
				index = table[i - 1];
				while (s.charAt(index) != s.charAt(i) && index > 0) {
					index = table[index - 1];
				}
				if (s.charAt(index) == s.charAt(i)) {
					index++;
				}
				table[i] = index;
			}
		}
		return table[table.length - 1];
	}

	public String shortestPalindrome(String s) {
		String tem = s + '*' + new StringBuilder(s).reverse().toString();
		int index = getKMP(tem);
		return new StringBuilder(s.substring(index)).reverse().toString() + s;
	}
}
