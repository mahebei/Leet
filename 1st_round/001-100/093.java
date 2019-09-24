/*
93. Restore IP Addresses
Medium

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/

class Solution {
	public List<String> IPAddress(String s, int[] IP, int i, List<String> res) {
		if (IP[3] != -1 && s.isEmpty()) {
			res.add(IP[0] + "." + IP[1] + "." + IP[2] + "." + IP[3]);
		}
		for (; i < 4; i++) {
			if (i == 0 || IP[i - 1] != -1) {
				if (!s.isEmpty() && s.charAt(0) == '0') {
					IP[i] = 0;
					IPAddress(s.substring(1), IP, i + 1, res);
					IP[i] = -1;
					continue;
				}
				for (int j = 1; j < 4; j++) {
					if (s.length() >= j && Integer.parseInt(s.substring(0, j)) < 256) {
						IP[i] = Integer.parseInt(s.substring(0, j));
						IPAddress(s.substring(j), IP, i + 1, res);
						IP[i] = -1;
					}
				}
			}
		}
		return res;
	}
	public List<String> restoreIpAddresses(String s) {
		int[] IP = {-1, -1, -1, -1};
		return IPAddress(s, IP, 0, new LinkedList<>());
	}
}
