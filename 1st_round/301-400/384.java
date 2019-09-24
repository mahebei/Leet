/*
384. Shuffle an Array
Medium

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

class Solution {
	int[] origin;
	int[] nums;

	public Solution(int[] nums) {
		origin = Arrays.copyOf(nums, nums.length);
		this.nums = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return origin;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		for (int i = 0; i < nums.length; i++) {
			int rand = (int) (Math.random() * nums.length);
			int tem = nums[rand];
			nums[rand] = nums[0];
			nums[0] = tem;
		}
		return nums;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
