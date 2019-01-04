/*
347. Top K Frequent Elements
Medium

Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(map::get));
		for (int num : map.keySet()) {
			pq.offer(num);
			if (pq.size() > k) pq.poll();
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(0, pq.poll());
		}
		return res;
	}
}
