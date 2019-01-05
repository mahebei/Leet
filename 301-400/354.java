/*
354. Russian Doll Envelopes
Hard

You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
One envelope can fit into another if and only if both the width and height of one envelope is greater than 
the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
Rotation is not allowed.

Example:

Input: [[5,4],[6,4],[6,7],[2,3]]
Output: 3 
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/

class Solution {
	public int maxEnvelopes(int[][] envelopes) {
		int[] memo = new int[envelopes.length];
		Arrays.sort(envelopes, Comparator.comparing((int[] arr) -> arr[0]));
		int max = 0;
		for (int i = 0; i < envelopes.length; i++) {
			memo[i] = 1;
			for (int j = 0; j < i; j++) {
				if (envelopes[i][0] == envelopes[j][0]) break;
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					memo[i] = Math.max(memo[i], memo[j] + 1);
				}
			}
			max = Math.max(max, memo[i]);
		}
		return max;
	}
}
