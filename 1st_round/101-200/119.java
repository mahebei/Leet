/*
119. Pascal's Triangle II
Easy

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/

class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new LinkedList<>();
		res.add(1);
		if (rowIndex == 0) return res;
		long curr;
		for (int i = 1; i <= rowIndex; i++) {
			curr = (long) res.get(i - 1) * (rowIndex - i + 1);
			curr /= i;
			res.add((int) curr);
		}
		return res;
	}
}
