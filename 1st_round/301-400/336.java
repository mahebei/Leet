/*
336. Palindrome Pairs
Hard

Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]] 
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]] 
Explanation: The palindromes are ["battab","tabbat"]
*/

/*
	There are 4 situations to be a valid pair of the final result.
	1. There is an empty string in the array and with any palindrome strings in the array can be 2 pairs.
	2. Reversed of any string is also in words. (Cannot be itself).
	3. If any string has a cut position, that the 1st part is palindrome and the reversed 2nd part is in the array.
	4. If any string has a cut position, that the 2nd part is palindrome and the reversed 1st part is in the array.
*/

class Solution {
	public static boolean isPal(String word) {
		for (int i = 0; i < word.length() / 2; i++) {
			if (word.charAt(i) != word.charAt(word.length() - i - 1)) return false;
		}
		return true;
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new LinkedList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], i);
		}
		if (map.containsKey("")) {
			int index = map.get("");
			for (int i = 0; i < words.length; i++) {
				if (!words[i].equals("")) {
					if (isPal(words[i])) {
						res.add(Arrays.asList(index, i));
						res.add(Arrays.asList(i, index));
					}
				}
			}
		}
		for (int i = 0; i < words.length; i++) {
			String rev = new StringBuilder(words[i]).reverse().toString();
			if (map.containsKey(rev) && !words[i].equals(rev)) {
				res.add(Arrays.asList(i, map.get(rev)));
			}
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = 1; j < words[i].length(); j++) {
				if (isPal(words[i].substring(0, j))) {
					String rev = new StringBuilder(words[i].substring(j)).reverse().toString();
					if (map.containsKey(rev)) res.add(Arrays.asList(map.get(rev), i));
				}
				if (isPal(words[i].substring(j))) {
					String rev = new StringBuilder(words[i].substring(0, j)).reverse().toString();
					if (map.containsKey(rev)) res.add(Arrays.asList(i, map.get(rev)));
				}
			}
		}
		return res;
	}
}
