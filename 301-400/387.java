/*
387. First Unique Character in a String

Easy

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1. 

Examples: 
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
*/

class Solution {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> unique = new HashMap<>();
		HashSet<Character> dup = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!dup.contains(ch)) {
				if (!unique.containsKey(ch)) {
					unique.put(ch, i);
				} else {
					unique.remove(ch);
					dup.add(ch);
				}
			}
		}
		if (unique.isEmpty()) return -1;
		int res = Integer.MAX_VALUE;
		for (int num : unique.values()) {
			res = Math.min(res, num);
		}
		return res;
	}
}
