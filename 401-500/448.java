/*
448. Find All Numbers Disappeared in an Array

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example: 
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
*/

class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int i = 0;
		while (i < nums.length) {
			while (i < nums.length && (i + 1 == nums[i] || nums[nums[i] - 1] == nums[i] || nums[i] > nums.length)) i++;
			if (i < nums.length) {
				int tem = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tem;
			}
		}
		i = 0;
		while (i < nums.length) {
			if (nums[i] != ++i) res.add(i);
		}
		return res;
	}
}
