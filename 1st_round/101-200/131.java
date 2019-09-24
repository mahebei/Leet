/*
131. Palindrome Partitioning
Medium

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/

class Solution {
	public boolean isPalindrome(String s) {
		if (s.isEmpty()) return false;
		for (int i = 0; i <= s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
		}
		return true;
	}
	
	public List<List<String>> parti(String s, List<List<String>> res, List<String> item) {
		if (isPalindrome(s)) {
			item.add(s);
			res.add(new LinkedList<>(item));
			item.remove(item.size() - 1);
		}
		for (int i = 1; i < s.length(); i++) {
			if (isPalindrome(s.substring(0, i))) {
				item.add(s.substring(0, i));
				parti(s.substring(i), res, item);
				item.remove(item.size() - 1);
			}
		}
		return res;
	}
	
	public List<List<String>> partition(String s) {
		if (s.isEmpty()) return new LinkedList<>();
		return parti(s, new LinkedList<>(), new LinkedList<>());
	}
}
