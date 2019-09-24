/*
414. Third Maximum Number
Easy

Given a non-empty array of integers, return the third maximum number in this array.
If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

class Solution {
	public int thirdMax(int[] nums) {
		Integer n1 = null, n2 = n1, n3 = n1;
		for (Integer num : nums) {
			if (num.equals(n1) || num.equals(n2) || num.equals(n3)) continue;
			if (n1 == null || num > n1) {
				n3 = n2;
				n2 = n1;
				n1 = num;
			} else if (n2 == null || num > n2) {
				n3 = n2;
				n2 = num;
			} else if (n3 == null || num > n3) {
				n3 = num;
			}
		}
		return (n3 == null) ? n1 : n3;
	}
}
