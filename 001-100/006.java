/*
6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/

class Solution {
	public String convert(String s, int numRows) {
		if (numRows < 2) {
			return s;
		}
		String result = "";
		for (int j = 0; j < s.length(); j += 2 * numRows - 2) {
			result += s.charAt(j);
		}
		for (int i = 1; i < numRows - 1; i++) {
			for (int j = 0; j - i< s.length(); j += 2 * numRows - 2) {
				if (j - i > 0) {
					result += s.charAt(j - i);
				}
				if (j + i < s.length()) {
					result += s.charAt(j + i);
				}
			}
		}
		for (int j = numRows - 1; j < s.length(); j += 2 * numRows - 2) {
			result += s.charAt(j);
		}
		return result;
    }
}
