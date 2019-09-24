/*
49. Group Anagrams

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new LinkedList<>();
		List<String> thumb = new LinkedList<>();
		for (int i = 0; i < strs.length; i++) {
			char[] letters = strs[i].toCharArray();
			Arrays.sort(letters);
			String rearranged = String.valueOf(letters);
			int index = thumb.indexOf(rearranged);
			if (index != -1) {
				res.get(index).add(strs[i]);
			} else {
				thumb.add(rearranged);
				List<String> newList = new LinkedList<>();
				newList.add(strs[i]);
				res.add(new LinkedList<>(newList));
			}
		}
		return res;
	}
}
