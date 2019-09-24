/*
207. Course Schedule
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

/*
Build a topological sorting, then use dfs to check if there is a loop. Use memo to store checked courses to save time.
*/
class Solution {
	public boolean dfs(List<List<Integer>> graph, boolean[] visited, int course, boolean[] memo) {
		if (visited[course]) return memo[course];
		visited[course] = true;
		List<Integer> list = graph.get(course);
		for (int i = 0; i < list.size(); i++) {
			if (!dfs(graph, visited, list.get(i), memo)) {
				memo[course] = false;
				return false;
			}
		}
		memo[course] = true;
		return true;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new LinkedList<>();
		boolean[] memo = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph.add(new LinkedList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i, memo)) {
				return false;
			}
		}
		return true;
	}
}
