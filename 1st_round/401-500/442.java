/*
442. Find All Duplicates in an Array
Medium

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?


Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/

class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		HashSet<Integer> res = new HashSet<>();
		int i = 0;
		while (i < nums.length) {
			while (i < nums.length && (nums[i] == i + 1 || nums[i] == nums[nums[i] - 1])) {
				if (nums[i] != i + 1) res.add(nums[i]);
				i++;
			}
			if (i >= nums.length) break;
			int tem = nums[nums[i] - 1];
			nums[nums[i] - 1] = nums[i];
			nums[i] = tem;
		}
		return new ArrayList<>(res);
	}
}
