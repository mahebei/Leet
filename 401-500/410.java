/*
410. Split Array Largest Sum
Hard

Given an array which consists of non-negative integers and an integer m,
you can split the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
*/

class Solution {
	public boolean isValid(int[] nums, int m, long tar) {
		int count = 1, sum = 0;
		for (int num : nums) {
			if (sum + num <= tar) sum += num;
			else {
				sum = num;
				if (++count > m) return false;
			}
		}
		return true;
	}

	public int splitArray(int[] nums, int m) {
		int max = Integer.MIN_VALUE, sum = 0;
		for (int num : nums) {
			max = Math.max(max, num);
			sum += num;
		}
		if (m == 1) return sum;
		long l = max, r = sum, mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (isValid(nums, m, mid)) r = mid - 1;
			else l = mid + 1;
		}
		return (int) l;
	}
}
