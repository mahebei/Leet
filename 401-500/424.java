/*
424. Longest Repeating Character Replacement
Medium

Given a string that consists of only uppercase English letters,
you can replace any letter in the string with another letter at most k times.
Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/

/*
Use slinding window to keep current longest substring, when k is enough, right bound ++, else left bound ++.
Trace the num of most frequent letter, also trace the length of longest substring.
*/
class Solution {
	public int characterReplacement(String s, int k) {
		int l = 0, r = 0, curr = 0, res = 0;
		int[] count = new int[26];
		while (r < s.length()) {
			curr = Math.max(curr, ++count[s.charAt(r) - 'A']);
			if (r - l + 1 - curr > k) {
				count[s.charAt(l) - 'A']--;
				l++;
			}
			res = Math.max(res, r - l + 1);
			r++;
		}
		return res;
	}
}
