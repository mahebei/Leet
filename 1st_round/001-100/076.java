/*
76. Minimum Window Substring
Hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

*/

class Solution {
	public String minWindow(String s, String t) {
		if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			if (map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
			} else {
				map.put(t.charAt(i), 1);
			}
		}
		int l = 0, r = 0, len = 0;
		int resL = 0, resR = s.length() + 1;
		while (r < s.length()) {
			if (map.containsKey(s.charAt(r))) {
				map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
				if (map.get(s.charAt(r)) >= 0) {
					len++;
				}
				while (len == t.length()) {
					if (r - l + 1 < resR - resL) {
						resL = l;
						resR = r + 1;
					}
					if (map.containsKey(s.charAt(l))) {
						map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
						if (map.get(s.charAt(l)) > 0) {
							len--;
						}
					}
					l++;
				}
			}
			r++;
		}
		if (resR - resL > s.length()) {
			return "";
		}
		return s.substring(resL, resR);
	}
}
