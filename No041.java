package no001_100;

public class No041 {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
				int tem = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[tem - 1] = tem;
				if (nums[i] != i + 1) i--;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) return i + 1;
		}
		return nums.length + 1;
	}
}
