package no001_100;

public class No055 {
	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len == 0) return true;
		int max = nums[0], i = 0;
		while (max >= i) {
			max = Math.max(max, i + nums[i]);
			if (max >= len - 1) return true;
			i++;
		}
		return false;
	}
}
