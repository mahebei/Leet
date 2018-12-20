/*
239. Sliding Window Maximum
Hard

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position. 
Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

/*
	Use a dequeue to solve this problem, store the indices in the dequeue.
	While the head of the dequeue is no longer in the windows, remove it. (Line 43)
	While the next is greater than tail remove from tail until dequeue is empty or no smaller(useless) elements. (Line 44)
	The greatest one is always at the head. (Line 46)
*/
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || k < 1) return new int[0];
		int[] res = new int[nums.length - k + 1];
		Deque<Integer> dequeue = new ArrayDeque<>();
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!dequeue.isEmpty() && dequeue.peek() <= i - k) dequeue.poll();
			while (!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]) dequeue.pollLast();
			dequeue.offer(i);
			if (i >= k - 1) res[index++] = nums[dequeue.peek()];
		}
		return res;
	}
}
