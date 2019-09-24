package no001_100;

import java.util.*;

public class No017 {
	public List<String> letterCombinations(String digits) {
		String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> res = new ArrayList<>();
		res.add("");
		for (char digit : digits.toCharArray()) {
			int size = res.size();
			for (int i = 0; i < size; i++) {
				String curr = res.remove(0);
				for (char letter : letters[digit - '0'].toCharArray()) {
					res.add(curr + letter);
				}
			}
		}
		return res;
	}
}
