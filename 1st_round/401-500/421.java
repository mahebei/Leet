/*
421. Maximum XOR of Two Numbers in an Array
Medium

Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
*/

class Solution {
	class Trie {
		Trie[] next;

		public Trie() {
			next = new Trie[2];
		}
	}

	public int findMaximumXOR(int[] nums) {
		if (nums.length == 0) return 0;
		int res = 0;
		Trie root = new Trie();
		for (int i : nums) {
			Trie currNode = root, compare = root;
			int curr = 0;
			for (int j = 30; j >= 0; j--) {
				int bit = (i >>> j) & 1;
				if (currNode.next[bit] == null) currNode.next[bit] = new Trie();
				currNode = currNode.next[bit];
				if (compare != null) {
					if (compare.next[bit ^ 1] != null) {
						curr += (1 << j);
						compare = compare.next[bit ^ 1];
					} else {
						compare = compare.next[bit];
					}
				}
			}
			res = Math.max(res, curr);
		}
		return res;
	}
}
