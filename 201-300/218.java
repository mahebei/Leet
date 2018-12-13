/*
This solution to this problem is to split a building to a starting point and an ending point, with height. To distinguish, starting point with positive heights, ending point with negative heights, then sort them. Iterate these points, use a priorityqueue to store current heights, higher height has higher priority. If a building starts, add the height to pq, if a building ends, remove the height from pq, if current highest height changes, add {current point, current highest height} to result.
*/
class Solution {
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> height = new LinkedList<>();
		List<int[]> res = new LinkedList<>();
		for (int i = 0; i < buildings.length; i++) {
			height.add(new int[]{buildings[i][0], buildings[i][2]});
			height.add(new int[]{buildings[i][1], -buildings[i][2]});
		}
		// Use customized sort, lambda expression
		Collections.sort(height, (a, b) -> {
			if (a[0] != b[0]) return a[0] - b[0];
			return b[1] - a[1];
		});
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); //(a,b)->(b-a) is to set larger number has higher priority
		pq.add(0);
		int pre = 0;
		for (int[] h : height) {
			if (h[1] > 0) {
				pq.add(h[1]);
			} else {
				pq.remove(-h[1]);
			}
			if (pre != pq.peek()) {
				res.add(new int[]{h[0], pq.peek()});
				pre = pq.peek();
			}
		}
		return res;
	}
}
