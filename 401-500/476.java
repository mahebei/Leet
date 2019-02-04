/*
476. Number Complement
Easy

Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*/

/*
~num is to get real not num, Integer.highestOneBit(num) - 1 is to get all 1s on all bits after first 1.
For example, num = 101, ~num = 11111010, Integer.highestOneBit(num) - 1 is 00000011.
Use & of these two numbers, get 00000010, which is the result.
*/
class Solution {
	public int findComplement(int num) {
		return ~num & Integer.highestOneBit(num) - 1;
	}
}
