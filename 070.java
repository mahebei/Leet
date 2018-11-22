/*
70. Climbing Stairs
Easy

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

/*
It's a fibonacci sequence.
*/
class Solution {
	public int solve(int n, int[] stairs) {
		if (n == 0) return 1;
		if (n < 0) return 0;
		if (stairs[n] > 0) return stairs[n];
		stairs[n] += solve(n - 1, stairs);
		stairs[n] += solve(n - 2, stairs);
		return stairs[n];
	}
	public int climbStairs(int n) {
		int[] stairs = new int[n + 1];
		solve(n, stairs);
		return stairs[n];
	}
}
