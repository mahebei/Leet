package no001_100;

public class No026 {
	public int removeDuplicates(int[] nums) {
		int i = 0, j = 1;
		while (j < nums.length) {
			while (nums[j] == nums[i]) j++;
			int tem = nums[j];
			nums[j] = nums[i + 1];
			nums[i + 1] = tem;
			i++;
			j++;
		}
		return i + 1;
	}
}
