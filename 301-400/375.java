/*
375. Guess Number Higher or Lower II
Medium

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. 
You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
*/

class Solution {
	public int getMoney(int[][] memo, int l, int r) {
		if (l >= r) return 0;
		if (memo[l][r] != 0) return memo[l][r];
		int res = Integer.MAX_VALUE;
		for (int i = l; i <= r; i++) {
			res = Math.min(res, i + Math.max(getMoney(memo, l, i - 1), getMoney(memo, i + 1, r)));
		}
		memo[l][r] = res;
		return res;
	}

	public int getMoneyAmount(int n) {
		int[][] memo = new int[n + 2][n + 2];
		return getMoney(memo, 1, n);
	}
}
