/*
423. Reconstruct Original Digits from English
Medium

Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits.
That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
*/

class Solution {
	public String originalDigits(String s) {
		int[] map = new int[26];
		int[] nums = new int[10];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map[ch - 'a']++;
		}
		if (map['z' - 'a'] != 0) {
			nums[0] = map['z' - 'a'];
			map['z' - 'a'] -= nums[0];
			map['e' - 'a'] -= nums[0];
			map['r' - 'a'] -= nums[0];
			map['o' - 'a'] -= nums[0];
		}
		if (map['w' - 'a'] != 0) {
			nums[2] = map['w' - 'a'];
			map['t' - 'a'] -= nums[2];
			map['w' - 'a'] -= nums[2];
			map['o' - 'a'] -= nums[2];
		}
		if (map['x' - 'a'] != 0) {
			nums[6] = map['x' - 'a'];
			map['s' - 'a'] -= nums[6];
			map['i' - 'a'] -= nums[6];
			map['x' - 'a'] -= nums[6];
		}
		if (map['g' - 'a'] != 0) {
			nums[8] = map['g' - 'a'];
			map['e' - 'a'] -= nums[8];
			map['i' - 'a'] -= nums[8];
			map['g' - 'a'] -= nums[8];
			map['h' - 'a'] -= nums[8];
			map['t' - 'a'] -= nums[8];
		}
		if (map['u' - 'a'] != 0) {
			nums[4] = map['u' - 'a'];
			map['f' - 'a'] -= nums[4];
			map['o' - 'a'] -= nums[4];
			map['u' - 'a'] -= nums[4];
			map['r' - 'a'] -= nums[4];
		}
		if (map['h' - 'a'] != 0) {
			nums[3] = map['h' - 'a'];
			map['t' - 'a'] -= nums[3];
			map['h' - 'a'] -= nums[3];
			map['r' - 'a'] -= nums[3];
			map['e' - 'a'] -= nums[3] * 2;
		}
		if (map['o' - 'a'] != 0) {
			nums[1] = map['o' - 'a'];
			map['t' - 'a'] -= nums[1];
			map['h' - 'a'] -= nums[1];
			map['r' - 'a'] -= nums[1];
		}
		if (map['s' - 'a'] != 0) {
			nums[7] = map['s' - 'a'];
			map['s' - 'a'] -= nums[7];
			map['e' - 'a'] -= nums[7] * 2;
			map['v' - 'a'] -= nums[7];
			map['n' - 'a'] -= nums[7];
		}
		if (map['f' - 'a'] != 0) {
			nums[5] = map['f' - 'a'];
			map['f' - 'a'] -= nums[5];
			map['i' - 'a'] -= nums[5];
			map['v' - 'a'] -= nums[5];
			map['e' - 'a'] -= nums[5];
		}
		nums[9] = map['i' - 'a'];
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < nums[i]; j++) {
				res.append(i);
			}
		}
		return res.toString();
    }
}
