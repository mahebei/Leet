package no001_100;

public class No042 {
	public int trap(int[] height) {
		if (height.length == 0) return 0;
		int l = 0, r = height.length - 1;
		int res = 0, curr = 0;
		while (l < r) {
			while (l < r && height[l] <= height[r]) {
				if (height[l] > curr) curr = height[l];
				else res += curr - height[l];
				l++;
			}
			while (l < r && height[l] >= height[r]) {
				if (height[r] > curr) curr = height[r];
				else res += curr - height[r];
				r--;
			}
		}
		return res;
	}
}
