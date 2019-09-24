/*
350. Intersection of Two Arrays II
Easy

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, 
and the memory is limited such that you cannot load all elements into the memory at once?
*/

class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> set = new HashMap<>();
		for (int num : nums1) {
			if (set.containsKey(num)) {
				set.put(num, set.get(num) + 1);
			}
			else set.put(num,1);
		}
		List<Integer> list = new ArrayList<>();
		for (int num : nums2) {
			if (set.containsKey(num)) {
				list.add(num);
				if (set.get(num) == 1) set.remove(num);
				else set.put(num, set.get(num)-1);				
			}
		}
		int[] res = new int[list.size()];
		int i = 0;
		for (int num : list) {
			res[i++] = num;
		}
		return res;
	}
}
