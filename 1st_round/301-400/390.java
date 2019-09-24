/*
390. Elimination Game
Medium

There is a list of sorted integers from 1 to n. Starting from left to right,
remove the first number and every other number afterward until you reach the end of the list.

Repeat the previous step again, but this time from right to left,
remove the right most number and every other number from the remaining numbers.

We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Find the last number that remains starting with a list of length n.

Example:

Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6
*/

/*
Trace the head, until there are one num left.
If the head is removed, there are 2 situations: nums are removed from left to right, or n is odd.
When head is removed, it goes to new head, new head = old head + 2 ^ round.
*/
class Solution {
	public int lastRemaining(int n) {
		int head = 1, step = 1;
		boolean isLeft = true;
		while (n > 1) {
			if (isLeft || n % 2 == 1) head += step;
			n /= 2;
			step *= 2;
			isLeft = !isLeft;
		}
		return head;
	}
}
