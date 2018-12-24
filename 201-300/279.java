/*
279. Perfect Squares
Medium

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

class Solution {
	public int numSquares(int n) {
		Queue<Integer> q = new LinkedList<>();
		HashMap<Integer, Integer> visited = new HashMap<>();
		q.offer(0);
		visited.put(0, 0);
		while (!q.isEmpty()) {
			int pre = q.peek();
			for (int i = (int) Math.sqrt(n - pre); i >= 1; i--) {
				int next = pre + i * i;
				if (next == n) return visited.get(pre) + 1;
				if (!visited.containsKey(next)) {
					q.offer(next);
					visited.put(next, visited.get(pre) + 1);
				}
			}
			q.poll();
		}
		return 4;
	}
}
