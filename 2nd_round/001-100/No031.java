package no001_100;

public class No031 {
	public void nextPermutation(int[] nums) {
		int i;
		for (i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) break;
		}
		int j;
		if (i > -1) {
			for (j = nums.length - 1; j > i; j--) {
				if (nums[j] > nums[i]) break;
			}
			int tem = nums[i];
			nums[i] = nums[j];
			nums[j] = tem;
		}
		j = nums.length - 1;
		i++;
		while (i < j) {
			int tem = nums[i];
			nums[i++] = nums[j];
			nums[j--] = tem;
		}
	}
}
