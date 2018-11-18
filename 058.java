/*
58. Length of Last Word
Easy

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/

class Solution {
	public int lengthOfLastWord(String s) {
		if (s.length() == 0) {
			return 0;
		}
		String[] strs = s.split(" ");
		for (int i = strs.length - 1; i >= 0; i++) {
			if (!strs[i].isEmpty()) {
				return strs[i].length();
			}
		}
		return 0;
	}
}
