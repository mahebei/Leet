/*
290. Word Pattern
Easy

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/

class Solution {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (pattern.length() != words.length) return false;
		HashMap<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			if (map.containsKey(ch)) {
				if (!map.get(ch).equals(words[i])) return false;
			} else {
				if (map.containsValue(words[i])) return false;
				map.put(ch, words[i]);
			}
		}
		return true;
	}
}
