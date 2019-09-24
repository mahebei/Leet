/*
115. Distinct Subsequences
Hard

Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of 
the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
*/

class Solution {
	public int numDistinct(String s, String t) {
		if (s.isEmpty() || t.isEmpty()) return 0;
		int[][] memo = new int[t.length()][s.length()];
		if (s.charAt(0) == t.charAt(0)) memo[0][0] = 1;
		for (int j = 1; j < s.length(); j++) {
			memo[0][j] = memo[0][j - 1];
			if (t.charAt(0) == s.charAt(j)) memo[0][j]++;
		}
		for (int i = 1; i < memo.length; i++) {
			for (int j = i; j < memo[0].length; j++) {
				memo[i][j] = memo[i][j - 1];
				if (t.charAt(i) == s.charAt(j)) memo[i][j] += memo[i - 1][j - 1];
			}
		}
		return memo[t.length() - 1][s.length() - 1];
	}
}
