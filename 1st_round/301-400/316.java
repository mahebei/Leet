/*
316. Remove Duplicate Letters
Hard

Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: "bcabc"
Output: "abc"
Example 2:

Input: "cbacdcbc"
Output: "acdb"
*/

class Solution {
	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		int min = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(min)) min = i; // find the min letter (until break on next line or the end of string)
			if (--count[s.charAt(i) - 'a'] == 0) break; // break if no duplicate curr letter after curr position
		}
		if (s.length() == 0) return "";
		// keep the letter at min position, remove duplicate at any other position
		return s.charAt(min) + removeDuplicateLetters(s.substring(min + 1).replaceAll("" + s.charAt(min), ""));
	}
}
