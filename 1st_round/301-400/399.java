/*
399. Evaluate Division
Medium

Equations are given in the format A / B = k, where A and B are variables represented as strings,
and k is a real number (floating point number). Given some queries, return the answers.
If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries,
where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero
and there is no contradiction.
*/

class Solution {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		HashMap<String, HashMap<String, Double>> map = new HashMap<>(); // map<A, <B, k>>
		for (int i = 0; i < equations.length; i++) {
			if (!map.containsKey(equations[i][0])) {
				map.put(equations[i][0], new HashMap<>());
			}
			map.get(equations[i][0]).put(equations[i][1], values[i]);
			if (!map.containsKey(equations[i][1])) {
				map.put(equations[i][1], new HashMap<>());
			}
			map.get(equations[i][1]).put(equations[i][0], 1 / values[i]);
		}
		double[] res = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			res[i] = dfs(queries[i][0], queries[i][1], map, new HashSet<String>(), 1.0);
			if (res[i] == 0) res[i] = -1.0;
		}
		return res;
	}

	public double dfs(String s, String e, HashMap<String, HashMap<String, Double>> map, HashSet<String> visited, double res) {
		if (visited.contains(s) || !map.containsKey(s)) return 0.0;
		if (s.equals(e)) return res;
		visited.add(s);
		double curr = 0.0;
		HashMap<String, Double> sub = map.get(s);
		for (String str : sub.keySet()) {
			curr = dfs(str, e, map, visited, res * sub.get(str));
			if (curr != 0) break;
		}
		visited.remove(s);
		return curr;
	}
}
