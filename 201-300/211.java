/*
211. Add and Search Word - Data structure design
Medium

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

class WordDictionary {
	class Trie {
		Trie[] next = new Trie[26];
		boolean isWord = false;
	}

	Trie root;

	/**
	 * Initialize your data structure here.
	 */
	public WordDictionary() {
		root = new Trie();
	}

	/**
	 * Adds a word into the data structure.
	 */
	public void addWord(String word) {
		Trie tem = root;
		for (int i = 0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			if (tem.next[index] == null) tem.next[index] = new Trie();
			tem = tem.next[index];
		}
		tem.isWord = true;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		return search(word, root);
	}

	public boolean search(String word, Trie trie) {
		if (word.length() == 0) return trie.isWord;
		char ch = word.charAt(0);
		if (ch != '.') {
			if (trie.next[ch - 'a'] == null) return false;
			return search(word.substring(1), trie.next[ch - 'a']);
		}
		for (int i = 0; i < 26; i++) {
			if (trie.next[i] != null && search(word.substring(1), trie.next[i]) == true) {
				return true;
			}
		}
		return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
