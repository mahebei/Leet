/*
212. Word Search II
Hard

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally 
or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

/*
Use Trie to store all words to be found. Search every letter in the char[][].
*/
class Solution {
	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		boolean isWord = false;
	}

	public List<String> dfs(char[][] board, TrieNode trie, int i, int j, String str, List<String> res) {
		if (trie == null) return res;
		str += board[i][j];
		if (trie.isWord) {
			res.add(str);
			trie.isWord = false;
		}
		char ch = board[i][j];
		board[i][j] = '0';
		if (i > 0 && board[i - 1][j] != '0') {
			res = dfs(board, trie.next[board[i - 1][j] - 'a'], i - 1, j, str, res);
		}
		if (j > 0 && board[i][j - 1] != '0') {
			res = dfs(board, trie.next[board[i][j - 1] - 'a'], i, j - 1, str, res);
		}
		if (i < board.length - 1 && board[i + 1][j] != '0') {
			res = dfs(board, trie.next[board[i + 1][j] - 'a'], i + 1, j, str, res);
		}
		if (j < board[0].length - 1 && board[i][j + 1] != '0') {
			res = dfs(board, trie.next[board[i][j + 1] - 'a'], i, j + 1, str, res);
		}
		board[i][j] = ch;
		return res;
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new LinkedList<>();
		TrieNode trie = new TrieNode();
		for (String i : words) {
			TrieNode t = trie;
			for (int j = 0; j < i.length(); j++) {
				if (t.next[i.charAt(j) - 'a'] == null) t.next[i.charAt(j) - 'a'] = new TrieNode();
				t = t.next[i.charAt(j) - 'a'];
			}
			t.isWord = true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				res = dfs(board, trie.next[board[i][j] - 'a'], i, j, "", res);
			}
		}
		return res;
	}
}
