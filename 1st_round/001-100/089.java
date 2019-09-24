/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
A gray code sequence must begin with 0.

Example 1:

Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].
*/

class Solution {
	public List<Integer> grayCode(int n) {
		List<Integer> res = new LinkedList<>();
		String item = "";
		int num = 0;
		for (int i = 0; i < n; i++) {
			item += '0';
		}
		res.add(0);
		for (int i = 1; i < Math.pow(2, n); i++) {
			if (i % 2 == 1) {
				// Suppose "0" is the 0th, if i is odd, change the rightmost digit
				if (item.charAt(n - 1) == '1') {
					item = item.substring(0, n - 1) + '0';
					res.add(num - 1);
				} else {
					item = item.substring(0, n - 1) + '1';
					res.add(num + 1);
				}
			} else {
				// if i is even, find the rightmost digit which is '1', then change the left one of the rightmost '1'
				int index = item.lastIndexOf('1') - 1;
				int diff = (int) Math.pow(2, n - index - 1);
				if (item.charAt(index) == '1') {
					item = item.substring(0, index) + '0' + item.substring(index + 1, n);
					res.add(num - diff);
				} else {
					item = item.substring(0, index) + '1' + item.substring(index + 1, n);
					res.add(num + diff);
				}
			}
			num = res.get(res.size() - 1);
		}
		return res;
	}
}
