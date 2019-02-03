/*
451. Sort Characters By Frequency
Medium

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

class Solution {
	public String frequencySort(String s) {
		int[] counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i)]++;
		}
		List<Character>[] lists = new List[s.length() + 1];
		for (char i = 0; i < 256; i++) {
			if (counts[i] == 0) continue;
			if (lists[counts[i]] == null) lists[counts[i]] = new ArrayList<>();
			lists[counts[i]].add(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = s.length(); i > 0; i--) {
			if (lists[i] == null) continue;
			for (char ch : lists[i]) {
				for (int j = 0; j < i; j++) {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
}
