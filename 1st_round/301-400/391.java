/*
391. Perfect Rectangle
Hard

Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. 
For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) 
and top-right point is (2, 2)).


Example 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true. All 5 rectangles together form an exact cover of a rectangular region.

Example 2:

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]

Return false. Because there is a gap between the two rectangular regions.

Example 3:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]

Return false. Because there is a gap in the top center.

Example 4:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false. Because two of the rectangles overlap with each other.
*/

class Solution {
	public boolean isRectangleCover(int[][] rectangles) {
		HashSet<String> set = new HashSet<>();
		int area = 0;
		int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE, t = Integer.MIN_VALUE;
		for (int[] i : rectangles) {
			l = Math.min(l, i[0]);
			r = Math.max(r, i[2]);
			b = Math.min(b, i[1]);
			t = Math.max(t, i[3]);
			if (!set.contains(i[0] + "," + i[1])) set.add(i[0] + "," + i[1]);
			else set.remove(i[0] + "," + i[1]);
			if (!set.contains(i[0] + "," + i[3])) set.add(i[0] + "," + i[3]);
			else set.remove(i[0] + "," + i[3]);
			if (!set.contains(i[2] + "," + i[1])) set.add(i[2] + "," + i[1]);
			else set.remove(i[2] + "," + i[1]);
			if (!set.contains(i[2] + "," + i[3])) set.add(i[2] + "," + i[3]);
			else set.remove(i[2] + "," + i[3]);
			area += (i[3] - i[1]) * (i[2] - i[0]);
		}
		if (set.size() == 4 && set.contains(l + "," + t) && set.contains(l + "," + b) 
			&& set.contains(r + "," + t) && set.contains(r + "," + b)) {
			return area == (t - b) * (r - l);
		}
		return false;
	}
}
