/*
118. Pascal's Triangle
Easy

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new LinkedList<>();
		List<Integer> row = new LinkedList<>();
		for (int i = 0; i < Math.min(numRows, 2); i++) {
			row.add(1);
			res.add(new LinkedList<>(row));
		}
		if (numRows <= 2) return res;
		for (int i = 2; i < numRows; i++) {
			row.add(1, i);
			for (int j = 2; j < i; j++) {
				row.add(j, row.get(j) + row.get(j + 1));
				row.remove(j + 1);
			}
			res.add(new LinkedList<>(row));
		}
		return res;
	}
}
