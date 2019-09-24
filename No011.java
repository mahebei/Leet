package no001_100;

public class No011 {
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1, max = 0;
		while (i < j) {
			max = Math.max(max, (i - j) * Math.min(height[i], height[j]));
			if (height[i] > height[j]) j++;
			else i++;
		}
		return max;
	}
}
