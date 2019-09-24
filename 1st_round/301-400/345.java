/*
345. Reverse Vowels of a String
Easy

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
*/

class Solution {
	public String reverseVowels(String s) {
	   String vowels = "aeiouAEIOU";
		char[] chars = s.toCharArray();
		int p = 0, q = s.length() - 1;
		while (p < q) {
			if (vowels.indexOf(chars[p]) == -1) p++;
			if (vowels.indexOf(chars[q]) == -1) q--;
			if (vowels.indexOf(chars[p]) != -1 && vowels.indexOf(chars[q]) != -1) {
				char tem = chars[p];
				chars[p] = chars[q];
				chars[q] = tem;
				p++;
				q--;
			}
		}
		return new String(chars);
	}
}
