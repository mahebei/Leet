package no001_100;

import java.util.*;

public class No049 {
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int[] letters = new int[26];
			for (char ch : str.toCharArray()) {
				letters[ch - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int letter : letters) {
				sb.append(letter).append('*');
			}
			String count = sb.toString();
			if (!map.containsKey(count)) {
				map.put(count, new ArrayList<>());
			}
			map.get(count).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
