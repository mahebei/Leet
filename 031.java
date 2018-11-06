/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

class Solution {
	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		int j;
		int tem;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		if (i >= 0) {
			j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			tem = nums[i];
			nums[i] = nums[j];
			nums[j] = tem;
		}
		i++;
		j = nums.length - 1;
		while (j > i) {
			tem = nums[i];
			nums[i] = nums[j];
			nums[j] = tem;
			j--;
			i++;
		}
	}
}
