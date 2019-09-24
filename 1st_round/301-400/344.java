/*
344. Reverse String
Easy

Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"
Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
*/

class Solution {
	public String reverseString(String s) {
		char[] chars = s.toCharArray();
		int len = chars.length;
		for (int i = 0; i < len / 2; i++) {
			char temp = chars[i];
			chars[i] = chars[len - i - 1];
			chars[len - i - 1] = temp;
		}
		return new String(chars);
	}
}
