/*
91. Decode Ways
Medium

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
*/

class Solution {
	public int numDecodings(String s) {
		int[] memo = new int[s.length() + 1];
		if (s.isEmpty() || s.charAt(0) == '0') {
			return 0;
		}
		memo[s.length()] = 1;
		if (s.charAt(s.length() - 1) == '0') memo[s.length() - 1] = 0;
		else memo[s.length() - 1] = 1;
		for (int i = s.length() - 2; i >= 0; i--) {
			if (s.charAt(i) == '0') continue;
			if (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
				memo[i] = memo[i + 1] + memo[i + 2];
			} else {
				memo[i] = memo[i + 1];
			}
		}
		return memo[0];
	}
}
