/*
394. Decode String
Medium

Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits
are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

class Solution {
	public String decodeString(String s) {
		Stack<String> stack = new Stack<>();
		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			while (i < s.length() && Character.isLetter(s.charAt(i))) i++;
			if (l < i) {
				stack.push(s.substring(l, i));
				l = i;
			}
			if (i == s.length()) break;
			while (Character.isDigit(s.charAt(i))) i++;
			if (l < i) {
				stack.push(s.substring(l, i));
				stack.push("");
				l = i;
			}
			if (s.charAt(i) == '[') l++;
			else if (s.charAt(i) == ']') {
				String curr = "";
				while (!stack.peek().isEmpty()) curr = stack.pop() + curr;
				stack.pop();
				int n = (stack.isEmpty()) ? 1 : Integer.parseInt(stack.pop());
				String tem = "";
				for (int j = 0; j < n; j++) {
					tem += curr;
				}
				stack.push(tem);
				l++;
			}
		}
		String res = "";
		while (!stack.isEmpty()) res = stack.pop() + res;
		return res;
	}
}
