/*
132. Palindrome Partitioning II
Hard

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

class Solution {
	public int minCut(String s) {
		boolean[][] memo = new boolean[s.length()][s.length()];
		int[] cut = new int[s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			cut[i] = i - 1;
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || memo[j + 1][i - 1])) {
					memo[j][i] = true;
					cut[i + 1] = Math.min(cut[i + 1], cut[j] + 1);
				}
			}
		}
		return cut[s.length()];
	}
}
