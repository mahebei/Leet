/*
4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] agg = new int[nums1.length + nums2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] <= nums2[j]) {
				System.out.println(nums1[i]);
				agg[k++] = nums1[i++];
			}
			else if (nums1[i] > nums2[j]) {
				System.out.println(nums2[j]);
				agg[k++] = nums2[j++];
			}
		}
		while (i < nums1.length) {
			System.out.println(nums1[i]);
			agg[k++] = nums1[i++];
		}
		while (j < nums2.length) {
			System.out.println(nums2[j]);
			agg[k++] = nums2[j++];
		}
		
		if ((nums1.length + nums2.length) % 2 == 0) {
			return ((double)agg[k / 2] + (double)agg[k / 2 - 1]) / 2;			
		} else {
			return (double) agg[k / 2];
		}
    }
}
