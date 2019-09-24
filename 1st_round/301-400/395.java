/*
395. Longest Substring with At Least K Repeating Characters
Medium

Find the length of the longest substring T of a given string (consists of lowercase letters only)
such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

class Solution {
	public int longestSubstring(String s, int k) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		boolean valid = true;
		for (int i : count) {
			if (i > 0 && i < k) {
				valid = false;
				break;
			}
		}
		if (valid) return s.length();
		int l = 0, res = 0, idx = 0;
		while (idx <= s.length()) {
			if (idx == s.length() || count[s.charAt(idx) - 'a'] < k) {
				res = Math.max(res, longestSubstring(s.substring(l, idx), k));
				l = idx+1;
			}
			idx++;
		}
		return res;
	}
}
