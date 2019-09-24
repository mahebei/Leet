package no001_100;

import java.util.Arrays;

public class No045 {
	public int jump(int[] nums) {
		int len = nums.length;
		if (len == 1) return 0;
		int max = 0, steps = 0, pre = 0;
		for (int i = 0; i < len; i++) {
			steps++;
			while (i <= pre) {
				if (max < i + nums[i]) {
					max = i + nums[i];
					if (max >= len - 1) return steps;
				}
				i++;
			}
			i--;
			pre = max;
		}
		return steps;
	}
}