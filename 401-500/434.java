/*
434. Number of Segments in a String
Easy

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
*/

class Solution {
	public int countSegments(String s) {
		String[] strs = s.split(" ");
		int count = 0;
		for (String str : strs) {
			if (!str.trim().isEmpty()) count++;
		}
		return count;
	}
}
