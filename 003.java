/*
003 Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", which the length is 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
	public int lengthOfLongestSubstring(String s) {
		int ans = 0;
		int count;
		int left = 0;
		if (s.length() < 2) {
			return s.length();
		}

		for (int i = 1; i < s.length(); i++) {
			count = 1;
			for (int j = i - 1; j >= left; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					left = j + 1;
					break;
				}
				count++;
			}
			if (count > ans) {
				ans = count;
			}
		}

		return ans;
	}
}
