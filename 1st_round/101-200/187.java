/*
187. Repeated DNA Sequences
Medium

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, 
it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
*/

class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new LinkedList<>();
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String pattern = s.substring(i, i + 10);
			if (set.contains(pattern) && !res.contains(pattern)) res.add(pattern);
			else set.add(pattern);
		}
		return res;
	}
}
