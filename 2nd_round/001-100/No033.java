package no001_100;

public class No033 {
	public int search(int[] nums, int target) {
		if (nums.length == 0) return -1;
		int l = 0, r = nums.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (nums[m] == target) return m;
			if (nums[m] > nums[l]) {
				if (target > nums[m] || target < nums[l]) l = m + 1;
				else r = m;
			} else {
				if (target > nums[r - 1] || target < nums[m]) r = m;
				else l = m + 1;
			}
		}
		return -1;
	}
}
