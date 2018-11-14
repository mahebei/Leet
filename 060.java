/*
60. Permutation Sequence
Medium

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
*/

class Solution {
	public String getPermutation(int n, int k) {
		if (n == 1) {
			return "1";
		}
		List<Integer> nums = new LinkedList<>();
		String res = "";
		int fac = 1, index;
		for (int i = 1; i <= n; i++) {
			nums.add(i);
			fac *= i;
		}
		for (int i = n; i >0; i--) {
			fac /= i;
			index = (k - 1) / fac;
			res += nums.get(index).toString();
			nums.remove(index);
			k = k % fac;
			if (k ==0){
				k += fac;
			}
		}
		return res;
	}
}
