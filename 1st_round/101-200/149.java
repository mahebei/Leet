/*
149. Max Points on a Line
Hard

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
	public int getGCD(int x, int y) {
		if (y == 0) return x;
		else return getGCD(y, x % y);
	}

	public int maxPoints(Point[] points) {
		// Use a pair of relatively prime numbers to represent the slope of the line. (Line 61 - 71) 
		// From every point, calculate slopes to any other points, if any two slopes are same, 
		   the corresponding counter++. (Line 72 - 82)
		if (points.length == 0) return 0;
		if (points.length <= 2) return points.length;
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		int res = 2;
		for (int i = 0; i < points.length; i++) {
			int same = 0, max = 0;
			map.clear();
			for (int j = i + 1; j < points.length; j++) {
				int x = points[i].x - points[j].x;
				int y = points[i].y - points[j].y;
				if (x == 0 && y == 0) {
					same++;
					continue;
				}
				int gcd = getGCD(x, y);
				if (gcd != 0) {
					x /= gcd;
					y /= gcd;
				}
				if (map.containsKey(x)) {
					if (map.get(x).containsKey(y)) {
						map.get(x).put(y, map.get(x).get(y) + 1);
					} else {
						map.get(x).put(y, 1);
					}
				} else {
					HashMap<Integer, Integer> curr = new HashMap<>();
					curr.put(y, 1);
					map.put(x, curr);
				}
				max = Math.max(max, map.get(x).get(y));
			}
			res = Math.max(res, max + same + 1);
		}
		return res;
	}
}
