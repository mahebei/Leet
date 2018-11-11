/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 
6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
	public int trap(int[] height) {
		if (height.length < 3) {
			return 0;
		}
		int l = 0, r = height.length - 1;
		int res = 0;
		while (height[l] <= 0) {
			l++;
		}
		while (height[r] <= 0) {
			r--;
		}
		int currHeight = Math.min(height[r], height[l]);
		while (l < r) {
			while (height[l] <= currHeight && l < r) {
				res += currHeight - height[l];
				l++;
			}
			while (height[r] <= currHeight && l < r) {
				res += currHeight - height[r];
				r--;
			}
			currHeight = Math.min(height[r], height[l]);
		}
		return res;
	}
}
