/*
201. Bitwise AND of Numbers Range
Medium

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
*/

/*
This problem is to find the common bits of m and n based 2. For example, 5 and 7, the common bits are: 000000100, which is 4.
*/
class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		int i = 0;
		while (m != n) {
			i++;
			m >>= 1;
			n >>= 1;
		}
		return m << i;
	}
}
