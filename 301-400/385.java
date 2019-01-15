/*
385. Mini Parser
Medium

Given a nested list of integers represented as a string, implement a parser to deserialize it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Note: You may assume that the string is well-formed:

String is non-empty.
String does not contain white spaces.
String contains only digits 0-9, [, - ,, ].
Example 1:

Given s = "324",

You should return a NestedInteger object which contains a single integer 324.
Example 2:

Given s = "[123,[456,[789]]]",

Return a NestedInteger object containing a nested list with 2 elements:

1. An integer containing value 123.
2. A nested list containing two elements:
    i.  An integer containing value 456.
    ii. A nested list with one element:
         a. An integer containing value 789.
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
/*
Traverse the String s, There are few situations in s.
If it's a digit, continue;
If it's '[', if it's like "[[", just re-initial curr, if is nums + '[', push nums into stack for later use.
If it's ']', if it's like "nums]", add the nums to curr, if it's like "]]" do nothing,
		if stack is not empty ([nums1[nums2]nums3]), nums1 is in stack, curr is [nums2]nums3], take out and add curr after it.
If it's ',' and it's not following ']' add num before ',' to result. If it's like '],' continue.
*/
class Solution {
	public NestedInteger deserialize(String s) {
		if (s.isEmpty()) return null;
		if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
		int l = 0;
		Stack<NestedInteger> stack = new Stack<>();
		NestedInteger curr = null;
		for (int r = 0; r < s.length(); r++) {
			if (s.charAt(r) == '[') {
				if (curr != null) {
					stack.push(curr);
				}
				curr = new NestedInteger();
				l = r + 1;
			} else if (s.charAt(r) == ']') {
				String num = s.substring(l, r);
				if (!num.isEmpty()) curr.add(new NestedInteger(Integer.parseInt(num)));
				if (!stack.isEmpty()) {
					NestedInteger pop = stack.pop();
					pop.add(curr);
					curr = pop;
				}
				l = r + 1;
			} else if (s.charAt(r) == ',') {
				if (s.charAt(r - 1) != ']') {
					String num = s.substring(l, r);
					curr.add(new NestedInteger(Integer.parseInt(num)));
				}
				l = r + 1;
			}
		}
		return curr;
	}
}
