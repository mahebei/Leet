package no001_100;

import java.util.Stack;

public class No084 {
	public int largestRectangleArea(int[] heights) {
		Stack<Integer> s = new Stack<>();
		int res = 0, count = 0;
		for (int height : heights) {
			if (s.isEmpty() || height >= s.peek()) s.push(height);
			else {
				while (!s.isEmpty() && s.peek() > height) {
					res = Math.max(res, s.pop() * ++count);
				}
				while (count > 0) {
					s.push(height);
					count--;
				}
				s.push(height);
			}
		}
		while (!s.isEmpty()) {
			res = Math.max(res, s.pop() * ++count);
		}
		return res;
	}
}
