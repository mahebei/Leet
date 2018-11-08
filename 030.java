/*
You are given a string, s, and a list of words, words, that are all of the same length. 
Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once 
and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
*/

import java.util.*;
class Solution {
	public boolean check(String s, String[] words, Hashtable table) {
		int len = words[0].length();
		for (int i = 0; i < words.length; i++) {
			String word = s.substring(i * len, (i + 1) * len);
			if (!table.containsKey(word) || (int)table.get(word) == 0) {
				return false;
			}
			table.put(word, (int)table.get(word) - 1);
		}
		return true;
	}
	public Hashtable setHashTable(String[] words){
		Hashtable table = new Hashtable();
		for (int i = 0; i < words.length; i++) {
			if(!table.containsKey(words[i])){
				table.put(words[i], 1);
			}else {
				table.put(words[i], (int)table.get(words[i]) + 1);
			}
		}
		return table;
	}
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new LinkedList<>();
		if (words.length == 0 || s.isEmpty()) {
			return res;
		}
		int len = words[0].length();
		Hashtable table = setHashTable(words);		
		for (int i = 0; i <= s.length() - words.length * len; i++) {
			if (check(s.substring(i, i + words.length * len), words, table)) {
				res.add(i);
			}
			table = setHashTable(words);
		}
		return res;
	}
}
