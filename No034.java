package no001_100;

public class No034 {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
		int l = 0, r = nums.length;
		while (l < r) {
			int m = (l + r) / 2;
			if (nums[m] == target) {
				if (res[0] == -1 && (m == 0 || nums[m - 1] != target)) {
					res[0] = m;
					l = m + 1;
				}
				if (res[1] == -1 && (m == nums.length - 1 || nums[m + 1] != target)) {
					res[1] = m;
					r = m;
				}
				if (res[0] != -1 && res[1] != -1) return res;
				if (res[0] == -1) r = m;
				else l = m + 1;
			} else if (nums[m] > target) {
				r = m;
			} else l = m + 1;
		}
		if (res[0] != -1 && res[1] == -1) {
			l = res[0];
			r = nums.length;
			while (l < r) {
				int m = (l + r) / 2;
				if (nums[m] == target) {
					if (m == nums.length - 1 || nums[m + 1] != target) {
						res[1] = m;
						return res;
					} else l = m + 1;
				} else if (nums[m] > target) {
					r = m;
				} else l = m + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 9};
		int[] res = searchRange(nums, 3);
		System.out.println(res[0] + " " + res[1]);
	}
}
