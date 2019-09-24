package no001_100;

import java.util.*;

public class No093 {
	List<String> res = new ArrayList<>();

	public void restoreIpAddresses(String s, int part, String item) {
		if (s.length() == part || s.length() == part * 3) {
			int len = s.length() / part;
			for (int i = 0; i < s.length(); i += len) {
				String curr = s.substring(i, i + len);
				if (len > 1 && curr.charAt(0) == '0' || Integer.parseInt(curr) > 255) return;
				if (part-- < 4) curr = "." + curr;
				item += curr;
			}
			res.add(item);
			return;
		}
		if (s.length() < part || s.length() > part * 3) return;
		if (part == 1) {
			if (s.charAt(0) != '0' && Integer.parseInt(s) <= 255) {
				item += "." + s;
				res.add(item);
			}
			return;
		}
		for (int i = 1; i <= 3; i++) {
			String curr = s.substring(0, i);
			if (Integer.parseInt(curr) > 255) break;
			if (part < 4) curr = "." + curr;
			restoreIpAddresses(s.substring(i), part - 1, item + curr);
			if (curr.charAt(0) == '0' || (part < 4 && curr.charAt(1) == '0')) break;
		}
	}

	public List<String> restoreIpAddresses(String s) {
		restoreIpAddresses(s, 4, "");
		return res;
	}
}
