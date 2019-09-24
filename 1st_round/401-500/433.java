/*
433. Minimum Genetic Mutation
Medium

A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"),
where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations.
A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine
what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.
 

Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1
 

Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2
 

Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
*/

class Solution {
	public int minMutation(String start, String end, String[] bank) {
		Queue<String> queue = new LinkedList<>();
		Queue<Integer> steps = new LinkedList<>();
		queue.offer(start);
		steps.offer(0);
		int res = 0;
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			int step = steps.poll() + 1;
			for (int i = 0; i < bank.length; i++) {
				int diff = 0;
				if (bank[i].length() == 0) continue;
				for (int j = 0; j < 8; j++) {
					if (curr.charAt(j) != bank[i].charAt(j)) {
						if (diff++ == 1) break;
					}
				}
				if (diff > 1) continue;
				if (bank[i].equals(end)) return step;
				queue.offer(bank[i]);
				steps.offer(step);
				bank[i] = "";
			}
		}
		return -1;
	}
}
