package no001_100;

import java.util.Stack;

public class No020 {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
				continue;
			}
			if (stack.isEmpty()) return false;
			char pop = stack.pop();
			if (pop != ch - 1 && pop != ch - 2) return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(]"));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
		//System.out.println(isValid("()"));
	}
}
