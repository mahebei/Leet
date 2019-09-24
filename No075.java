package no001_100;

public class No075 {
	public void sortColors(int[] nums) {
		int l = 0, r = nums.length - 1, p = 0;
		while (p <= r) {
			while (l <= r && nums[l] == 0) l++;
			while (l <= r && nums[r] == 2) r--;
			if (l > r) return;
			if (p < l) p = l;
			if (nums[p] == 0) {
				nums[p] = nums[l];
				nums[l++] = 0;
			} else if (nums[p] == 2) {
				nums[p] = nums[r];
				nums[r--] = 2;
			} else p++;
		}
	}
}
