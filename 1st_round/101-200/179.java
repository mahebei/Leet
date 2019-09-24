/*
179. Largest Number
Medium

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

class Solution {
	public String largestNumber(int[] nums) {
		String[] strNums = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strNums[i] = "" + nums[i];
		}

		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		};

		Arrays.sort(strNums, comp);
		if(strNums[strNums.length - 1].charAt(0) == '0') return "0";
		StringBuilder sb = new StringBuilder();
		for (int i = strNums.length - 1; i >= 0; i--) {
			sb.append(strNums[i]);
		}
		return sb.toString();
	}
}
