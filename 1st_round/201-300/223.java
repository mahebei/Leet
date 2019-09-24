/*
223. Rectangle Area
Medium

Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area

Example:

Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
Output: 45
Note:

Assume that the total area is never beyond the maximum possible value of int.
*/

class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int res = 0;
		int l = Math.max(A, E);
		int b = Math.max(B, F);
		int r = Math.min(C, G);
		int t = Math.min(D, H);
		if (r > l && t > b) {
			res = -(r - l) * (t - b);
		}
		res += (C - A) * (D - B) + (G - E) * (H - F);
		return res;
	}
}
