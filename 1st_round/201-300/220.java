220. Contains Duplicate III
Medium

Given an array of integers, find out whether there are two distinct indices i and j in the array such that
the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false

class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length <= 1) return false;
		TreeSet<Long> ts = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) ts.remove((long) nums[i - k - 1]);
			Long l = ts.ceiling((long) nums[i] - t);
			Long r = ts.floor((long) nums[i] + t);
			if (r != null && l != null && r >= l) return true;
			ts.add((long) nums[i]);
		}
		return false;
	}
}
