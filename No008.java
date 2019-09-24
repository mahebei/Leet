package no001_100;

public class No008 {
	public int myAtoi(String str) {
		str = str.trim();
		if (str.isEmpty()) return 0;
		int res = 0, sign = 1;
		char ch = str.charAt(0);
		if (!Character.isDigit(ch)) {
			if (ch == '+' || ch == '-') {
				if (ch == '-') sign = -1;
				str = str.substring(1);
				if (str.isEmpty() || !Character.isDigit(str.charAt(0))) return 0;
			} else return 0;
		}
		int idx = 0;
		while (idx < str.length() && Character.isDigit(str.charAt(idx))) {
			ch = str.charAt(idx);
			if (sign == -1 && (Integer.MIN_VALUE / 10 > -res || (Integer.MIN_VALUE / 10 == -res && ch > '8')))
				return Integer.MIN_VALUE;
			if (sign == 1 && (Integer.MAX_VALUE / 10 < res) || (Integer.MAX_VALUE / 10 == res && ch > '7'))
				return Integer.MAX_VALUE;
			res = 10 * res + (ch - '0') * sign;
			idx++;
		}
		return res;
	}
}
