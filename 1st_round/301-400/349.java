/*
349. Intersection of Two Arrays
Easy

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		for (int num1 : nums1) {
			set1.add(num1);
		}
		for (int num2 : nums2) {
			if (set1.contains(num2)) set2.add(num2);
		}
		int[] res = new int[set2.size()];
		int i = 0;
		for (int num: set2) {
			res [i++] = num;
		}
		return res;
	}
}
