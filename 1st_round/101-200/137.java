/*
137. Single Number II
Medium
610
214


Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/

/*
Use bit operations to solve this problem.
Iterate each of 32 bits of an integer number (Line 33), at each bit, count the sum of all the numbers(Line 34-36).
if % 3 == 1, add the 1 on that bit to the res (Line 38-39).
*/
class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < nums.length; j++) {
				sum += ((nums[j] >> i) & 1);
			}
			if (sum % 3 == 1) {
				res |= 1 << i;
			}
		}
		return res;
	}
}
