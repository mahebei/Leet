/*
342. Power of Four
Easy

Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
*/

class Solution {
	public boolean isPowerOfFour(int num) {
		if (num <= 0) return false;
		int factor = 4;
		while (num % 4 == 0) {
			while (num % factor == 0) {
				num /= factor;
				factor *= 4;
			}
			factor /= 4;
		}
		return num == 1;
	}
}
