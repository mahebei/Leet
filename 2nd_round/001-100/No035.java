package no001_100;

public class No035 {
	public int searchInsert(int[] nums, int target) {
		int l = 0, r = nums.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (nums[m] == target) return m;
			if (nums[m] > target) {
				if (m == 0 || nums[m - 1] < target) return m;
				else r = m;
			} else if (nums[m] < target) {
				if (m == nums.length - 1 || nums[m + 1] > target) return m + 1;
				else l = m + 1;
			}
		}
		return l;
	}
}
