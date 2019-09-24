/*
125. Valid Palindrome
Easy

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

class Solution {
	public boolean isPalindrome(String s) {
		if (s == null) return true;
		s = s.toLowerCase();
		int l = s.length();
		StringBuilder str = new StringBuilder(l);
		for (char c : s.toCharArray()) {
			if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				str.append(c);
			}
		}
		return str.toString().equals(str.reverse().toString());
	}
}
