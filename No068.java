package no001_100;

import java.util.*;

public class No068 {
	public String addSpaces(List<String> strs, int maxWidth, int currLen) {
		StringBuilder sb = new StringBuilder();
		sb.append(strs.get(0));
		if (strs.size() == 1) {
			for (int i = 0; i < maxWidth - currLen; i++) {
				sb.append(' ');
			}
		}
		for (int i = 1; i < strs.size(); i++) {
			int spaces = (maxWidth - currLen) / (strs.size() - i);
			if ((maxWidth - currLen) % (strs.size() - i) != 0) spaces++;
			for (int j = 0; j < spaces; j++) {
				sb.append(' ');
			}
			currLen += spaces;
			sb.append(strs.get(i));
		}
		return sb.toString();
	}

	public List<String> solve(List<String> res, List<String> curr, int currLen, List<String> words, int maxWidth) {
		if (words.size() == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(curr.get(0));
			for (int i = 1; i < curr.size(); i++) {
				sb.append(' ').append(curr.get(i));
			}
			while(maxWidth > sb.length()) {
				sb.append(' ');
			}
			res.add(sb.toString());
			return res;
		}
		else if (currLen + words.get(0).length() + 1 > maxWidth) {
			res.add(addSpaces(curr, maxWidth, currLen - curr.size() + 1));
			curr.clear();
			currLen = 0;
		}
		curr.add(words.get(0));
		currLen += words.get(0).length();
		if (curr.size() > 1) currLen++;
		words.remove(0);
		res = solve(res, curr, currLen, words, maxWidth);
		return res;
	}


	public List<String> fullJustify(String[] words, int maxWidth) {
		return solve(new ArrayList<>(), new ArrayList<>(), 0, new ArrayList<String>(Arrays.asList(words)), maxWidth);
	}
}