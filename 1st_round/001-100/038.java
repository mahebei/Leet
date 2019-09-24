/*
38. Count and Say
Easy

The description on LeetCode is hard to understand, please reffer Look-and-say sequence.
*/

class Solution {
	public String countAndSay(int n) {
		String pre = "1";
		for (int i = 1; i < n; i++) {
			String curr = "";
			char digit = pre.charAt(0);
			int count = 1;
			for (int j = 1; j < pre.length(); j++) {
				if (pre.charAt(j) != pre.charAt(j - 1)) {
					curr += count;
					curr += digit;
					digit = pre.charAt(j);
					count = 1;
				} else {
					count++;
				}
			}
			curr += count;
			curr += digit;
			pre = curr;
		}
		return pre;
	}
}
