/*
228. Summary Ranges
Medium

Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

class Solution {
	public List<String> summaryRanges(int[] nums) {
		if (nums.length == 0) return new LinkedList<>();
		List<String> res = new LinkedList<>();
		int pre = nums[0];
		String item = "";
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > pre + 1) {
				if (item.isEmpty()) res.add("" + pre);
				else res.add(item + "->" + pre);
				item = "";
			} else if (item.isEmpty()) item += pre;
			pre = nums[i];
		}
		if (item.isEmpty()) res.add("" + pre);
		else res.add(item + "->" + pre);
		return res;
	}
}
