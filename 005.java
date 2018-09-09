/*
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
       	if (s.length() < 2) {
			return s;
		}
		String result = "";
		int len = 0;
		int max = 0;
		for (int i = 1; i < s.length(); i++) {
			len = 0;
			while (i - len >= 0 && i + len < s.length()) {

				if (s.charAt(i - len) == s.charAt(i + len)) {
					if (len >= max) {
						max = len;
						result = s.substring(i - len, i + len + 1);
					}
					len++;
				} else {

					break;
				}
			}
		}

		for (int i = max; i < s.length() - 1; i++) {
			len = 0;
			while (i - len >= 0 && i + len + 1 < s.length()
					&& s.charAt(i) == s.charAt(i + 1)) {
				if (s.charAt(i - len) == s.charAt(i + len + 1)) {
					if (len >= max) {
						max = len;
						result = s.substring(i - len, i + len + 2);
					}
					len++;
				} else {
					break;
				}
			}
		}
		return result;
    }
}
