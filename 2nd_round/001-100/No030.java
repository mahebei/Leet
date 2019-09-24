package no001_100;

import java.util.*;

public class No030 {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s.isEmpty() || words.length == 0) return res;
		int len = words[0].length();
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (word.length() != len) return res;
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (int i = 0; i <= s.length() - words.length * len; i++) {
			boolean flag = true;
			for (int j = 0; j < words.length * len; j += len) {
				String curr = s.substring(i + j, i + j + len);
				int count = map.getOrDefault(curr, 0) - 1;
				if (count < 0) {
					flag = false;
					break;
				}
				map.put(curr, count);
			}
			if (flag) res.add(i);
			map.clear();
			for (String word : words) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s2 = "wordgoodgoodgoodbestword";
		String[] words2 = {"word", "good", "best", "good"};
		System.out.println(findSubstring(s2, words2));
		String s1 = "barfoothefoobarman";
		String[] words1 = {"foo", "bar"};
		System.out.println(findSubstring(s1, words1));
	}
}
