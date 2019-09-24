package no001_100;

import java.util.Stack;

public class No071 {
	public String simplifyPath(String path) {
		String[] paths = path.split("/");
		Stack<String> stack = new Stack<>();
		for (String p : paths) {
			if (p.isEmpty() || p.equals(".")) continue;
			else if (p.equals("..")) {
				if (!stack.isEmpty()) stack.pop();
			} else {
				stack.push(p);
			}
		}
		StringBuilder res = new StringBuilder();
		while (!stack.isEmpty()) {
			res.insert(0, stack.pop());
			res.insert(0, '/');
		}

		return res.toString();
	}
}
