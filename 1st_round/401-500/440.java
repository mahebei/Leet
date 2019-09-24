/*
440. K-th Smallest in Lexicographical Order
Hard

Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

Note: 1 ≤ k ≤ n ≤ 109.

Example:

Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
*/

class Solution {
	public int findKthNumber(int n, int k) {
		int curr = 1;
		k--;
		while (k > 0) {
			int step = getStep(n, curr, curr + 1);
			if (k >= step) {
				curr++;
				k -= step;
			} else {
				curr *= 10;
				k--;
			}
		}
		return curr;
	}

	public int getStep(int n, long l, long r) {
		int step = 0;
		while (n >= l) {
			step += Math.min(r, n + 1) - l;
			l *= 10;
			r *= 10;
		}
		return step;
	}
}
