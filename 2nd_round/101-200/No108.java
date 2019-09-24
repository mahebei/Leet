package no001_100;

public class No108 {
	public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
		if (l == r) return null;
		int m = (l + r) / 2;
		TreeNode curr = new TreeNode(nums[m]);
		curr.left = sortedArrayToBST(nums, l, m);
		curr.right = sortedArrayToBST(nums, m + 1, r);
		return curr;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length);
	}
}
