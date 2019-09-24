package no001_100;

public class No080 {
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
		int curr = 1, p = 0, i = 1, len = nums.length;
		while (i < len) {
			if (nums[i] == nums[p] && curr < 2) {
				int temp = nums[i];
				nums[i] = nums[++p];
				nums[p] = temp;
				curr++;
			} else if (nums[i] != nums[p]) {
				int temp = nums[i];
				nums[i] = nums[++p];
				nums[p] = temp;
				curr = 1;
			}
			i++;
		}
		return p + 1;
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 1, 1, 2, 2, 2, 3, 3};
		int[] nums2 = {1, 1, 1, 2, 2, 3};
		int[] nums3 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
		int res1 = removeDuplicates(nums1);
		int res2 = removeDuplicates(nums2);
		int res3 = removeDuplicates(nums3);
		for (int i = 0; i < res1; i++) {
			System.out.print(nums1[i]);
		}
		System.out.println();
		for (int i = 0; i < res2; i++) {
			System.out.print(nums2[i]);
		}
		System.out.println();
		for (int i = 0; i < res3; i++) {
			System.out.print(nums3[i]);
		}
	}
}
