/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
	public List<String> combine(String digit, List<String> list) {
		List<String> rtn = new LinkedList<String>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < digit.length(); j++) {
				rtn.add(list.get(i) + digit.charAt(j));
			}
		}
		return rtn;
	}
	public List<String> letterCombinations(String digits) {
		List<String> res = new LinkedList<String>();
		if (digits.length() > 0) {
			res.add("");
			String[] pattern = {"abc", "def", "ghi", "jkl", "mno", "pqrs",
					"tuv", "wxyz"};
			for (int i = 0; i < digits.length(); i++) {
				res = combine(pattern[digits.charAt(i) - '2'], res);
			}
		}
		return res;
	}
}
