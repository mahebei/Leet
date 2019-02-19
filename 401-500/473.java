/*
473. Matchsticks to Square
Medium

Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
please find out a way you can make one square by using up all those matchsticks.
You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Your input will be several matchsticks the girl has, represented with their stick length.
Your output will either be true or false,
to represent whether you could make one square using all the matchsticks the little match girl has.

Example 1:
Input: [1,1,2,2,2]
Output: true

Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:
Input: [3,3,3,3,4]
Output: false

Explanation: You cannot find a way to form a square with all the matchsticks.
Note:
The length sum of the given matchsticks is in the range of 0 to 10^9.
The length of the given matchstick array will not exceed 15.
*/

class Solution {
	public static boolean check(int[] nums, int target) {
		if (target < 0) return false;
		if (target == 0) return true;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == -1) continue;
			int curr = nums[i];
			nums[i] = -1;
			if (!check(nums, target - curr)) nums[i] = curr;
			else return true;
		}
		return false;
	}

	public static boolean makesquare(int[] nums) {
		if (nums.length == 0) return false;
		int target = 0, count = 0;
		Arrays.sort(nums);
		for (int num : nums) {
			target += num;
		}
		if (target % 4 != 0 || nums[nums.length - 1] > target / 4) return false;
		target /= 4;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == -1) continue;
			if (!check(nums, target)) return false;
			else count++;
		}
		return (count == 4);
	}
}
