/*
84. Largest Rectangle in Histogram
Hard

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:

Input: [2,1,5,6,2,3]
Output: 10
*/

class Solution {
	public int largestRectangleArea(int[] heights) {
		int res = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < heights.length; i++) {
			if (stack.isEmpty() || heights[i] >= stack.peek()) {
				stack.push(heights[i]);
			} else {
				List<Integer> pop = new LinkedList<>();
				while (!stack.isEmpty() && stack.peek() > heights[i]) {
					pop.add(stack.pop());
				}
				while (!pop.isEmpty()) {
					if (pop.get(pop.size() - 1) * pop.size() > res) {
						res = pop.get(pop.size() - 1) * pop.size();
					}
					stack.push(heights[i]);
					pop.remove(pop.size() - 1);
				}
				stack.push(heights[i]);
			}
		}
		int count = 0;
		while (!stack.isEmpty()) {
			int height = stack.pop();
			count++;
			if (height * count > res) {
				res = height * count;
			}
		}
		return res;
	}
}
