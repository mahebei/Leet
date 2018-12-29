/*
318. Maximum Product of Word Lengths
Medium

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
where the two words do not share common letters. 
You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16 
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4 
Explanation: The two words can be "ab", "cd".
Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0 
Explanation: No such pair of words.
*/

class Solution {
	public int maxProduct(String[] words) {
		int letters[] = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				letters[i] |= 1 << (words[i].charAt(j) - 'a'); // Use a 32 bits int to store if has each of 26 letters.
			}
		}
		int res = 0; 
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((letters[i] & letters[j]) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return res;
	}
}
