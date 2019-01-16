/*
409. Longest Palindrome
Easy

Given a string which consists of lowercase or uppercase letters,
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
	public int longestPalindrome(String s) {
		int[] count = new int[255];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
		int single = 0, sum = 0;
		for (int n : count) {
			sum += n / 2;
			if (single == 0 && n % 2 == 1) single = 1;
		}
		return sum * 2 + single;
	}
}
