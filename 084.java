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

/*
In this problem, a monoton stack is used, a monoton stack is a "sorted" stack.
Line 33-34: If the stack is empty or the int to be added is greater than stack.peek(), push it in.
Line 35-45: Else, pop the stack until empty or the int to be added is greater than stack.peek(), 
			then check the area of poped ints.
			Change all poped ints to the one to be added then push them in and push the int in. 
Line 49-54: Check the area of all ints in the stack.
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
       int res = 0;
		Stack<Integer> stack = new Stack<>();
		int count;
		for (int i = 0; i < heights.length; i++) {
			if (stack.isEmpty() || heights[i] >= stack.peek()) {
				stack.push(heights[i]);
			} else {
				count = 0;
				while (!stack.isEmpty() && stack.peek() > heights[i]) {
					count++;
					int pop = stack.pop();
					if (pop * count > res) {
						res = pop * count;
					}
				}
				for (int j = 0; j <= count; j++) {
					stack.push(heights[i]);
				}
			}
		}
		count = 0;
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
