/*
480. Sliding Window Median
Hard

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
*/

class Solution {
	PriorityQueue<Integer> min = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	});
	PriorityQueue<Integer> max = new PriorityQueue<>();

	public double getMedian() {
		if (max.isEmpty() && min.isEmpty()) return 0;
		return min.size() == max.size() ? min.peek() / 2.0 + max.peek() / 2.0 : min.peek();
	}

	public void add(int num) {
		if (num <= getMedian()) min.offer(num);
		else max.offer(num);
		if (min.size() < max.size()) min.offer(max.poll());
		if (min.size() > max.size() + 1) max.offer(min.poll());
	}

	public void remove(int num) {
		if (num <= getMedian()) min.remove(num);
		else max.remove(num);
		if (min.size() < max.size()) min.offer(max.poll());
		if (min.size() > max.size() + 1) max.offer(min.poll());
	}

	public double[] medianSlidingWindow(int[] nums, int k) {
		if (nums.length < k) return new double[0];
		double[] res = new double[nums.length - k + 1];
		for (int i = 0; i <= nums.length; i++) {
			if (i > k - 1) {
				res[i - k] = getMedian();
				remove(nums[i - k]);
			}
			if (i < nums.length) add(nums[i]);
		}
		return res;
	}
}
