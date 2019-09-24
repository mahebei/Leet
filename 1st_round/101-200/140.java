/*
140. Word Break II
Hard

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

class Solution {
	public static List<String> getWords(String s, List<String> wordDict, HashMap<String, List<String>> map) {
		if (map.containsKey(s)) return map.get(s);
		List<String> res = new LinkedList<>();
		if (s.isEmpty()) {
			res.add("");
			return res;
		}
		for (int i = 0; i < wordDict.size(); i++) {
			String word = wordDict.get(i);
			if (s.startsWith(word)) {
				List<String> sub = getWords(s.substring(word.length()), wordDict, map);
				for (int j = 0; j < sub.size(); j++) {
					if (sub.get(j).isEmpty()) res.add(word);
					else res.add(word + " " + sub.get(j));
				}
			}
		}
		map.put(s, res);
		return res;
	}
	
	public static List<String> wordBreak(String s, List<String> wordDict) {
		HashMap<String, List<String>> map = new HashMap<>();
		List<String> res = getWords(s, wordDict, map);
		return res;
	}
}
