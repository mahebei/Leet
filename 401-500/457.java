/*
457. Circular Array Loop
Medium

You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps.
Conversely, if it's negative (-n), move backward n steps.
Assume the first element of the array is forward next to the last element,
and the last element is backward next to the first element. Determine if there is a loop in this array.
A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.

Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.

Example 2: Given the array [-1, 2], there is no loop.

Note: The given array is guaranteed to contain no element "0".

Can you do it in O(n) time complexity and O(1) space complexity?
*/

class Solution {
	public int getNext(int i, int num, int len) {
		return i + num >= 0 ? (i + num) % len : (i + num) % len + len;
	}

	public boolean circularArrayLoop(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 0) continue;
			int j = i, k = getNext(i, nums[i], len);
			while (nums[i] * nums[k] > 0 && nums[i] * nums[getNext(k, nums[k], len)] > 0) {
				if (j == k){
					if(j != getNext(j, nums[j], len)) return true;
					break;
				}
				j = getNext(j, nums[j], len);
				k = getNext(k, nums[k], len);
				k = getNext(k, nums[k], len);
			}
			j = i;
			while (nums[j] * nums[i] > 0){
				int next = getNext(j,nums[j],len);
				nums[j] = 0;
				j = next;
			}
		}
		return false;
	}
}
