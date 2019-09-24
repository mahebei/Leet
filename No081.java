package no001_100;

public class No081 {
	public boolean search(int[] nums, int target) {
		int l = 0, r = nums.length;
		while (l < r) {
			if (nums[l] == target || nums[r] == target) return true;
			if (nums[l] == nums[r]) {
				l++;
				r--;
				continue;
			}
			int m = (l + r) / 2;
			if (target == nums[m]) return true;
			if (nums[m] >= nums[l]) {
				if (target > nums[m]) l = m + 1;
				else r = m;
			} else{
				if (target > nums[l]) r = m;
				else l = m + 1;
			}
		}
		return false;
	}
}
