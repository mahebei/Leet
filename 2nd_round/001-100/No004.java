package no001_100;

public class No004 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//even len/2-1 + len / 2, odd len / 2
		int len1 = nums1.length, len2 = nums2.length;
		if (len1 == 0) {
			if (len2 % 2 == 1) return nums2[len2 / 2];
			return nums2[len2 / 2] / 2.0 + nums2[len2 / 2 - 1] / 2.0;
		}
		if (len2 == 0) {
			if (len1 % 2 == 1) return nums1[len1 / 2];
			return nums1[len1 / 2] / 2.0 + nums1[len1 / 2 - 1] / 2.0;
		}
		int p1 = 0, p2 = 0, pre = Integer.MIN_VALUE, curr = pre;
		while (p1 + p2 <= (len1 + len2) / 2) {
			if (p1 < len1 && p2 < len2) {
				if (nums1[p1] <= nums2[p2]) {
					if (pre < curr) pre = nums1[p1++];
					else curr = nums1[p1++];
				} else {
					if (pre < curr) pre = nums2[p2++];
					else curr = nums2[p2++];
				}
			} else {
				if (p1 < len1) {
					if (pre < curr) pre = nums1[p1++];
					else curr = nums1[p1++];
				} else {
					if (pre < curr) pre = nums2[p2++];
					else curr = nums2[p2++];
				}
			}
		}
		if ((len1 + len2) % 2 == 1) return Math.max(curr, pre);
		return (curr + pre) / 2.0;
	}

	public static void main(String[] args) {
		int[] nums3 = {1,3};
		int[] nums4 = {2};
		System.out.println(findMedianSortedArrays(nums3, nums4));
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		System.out.println(findMedianSortedArrays(nums1, nums2));

	}
}
