/*
127. Word Ladder
Medium

Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution {
	public boolean isValidTrans(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (++count > 1) return false;
			}
		}
		return count == 1;
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) return 0;
		if (isValidTrans(beginWord, endWord)) return 2;
		int res = 2;
		List<String> reached = new LinkedList<>();
		reached.add(beginWord);
		while (!wordList.isEmpty() && !reached.isEmpty()) {
			int size = reached.size();
			for (int i = 0; i < size; i++) {
				int j = 0;
				if (isValidTrans(reached.get(0), endWord)) return res;
				while (j < wordList.size()) {
					if (isValidTrans(wordList.get(j), reached.get(0))) {
						reached.add(wordList.get(j));
						wordList.remove(j);
					} else j++;
				}
				reached.remove(0);
			}
			res++;
		}
		return 0;
	}
}
