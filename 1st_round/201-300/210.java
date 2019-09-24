/*
210. Course Schedule II
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, 
return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. 
If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]] 
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
             course 0. So the correct course order is [0,1] .
Example 2:

Input: 4, [[1,0],[2,0],[3,1],[3,2]]
Output: [0,1,2,3] or [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
*/

class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> list = new LinkedList<>();
		int[] res = new int[numCourses];
		int[] linkCount = new int[numCourses];
		int count = 0;
		for (int i = 0; i < numCourses; i++) {
			list.add(new LinkedList<>());
		}
		for (int i = 0; i < prerequisites.length; i++) {
			list.get(prerequisites[i][1]).add(prerequisites[i][0]);
			linkCount[prerequisites[i][0]]++;
		}
		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < linkCount.length; i++) {
			if (linkCount[i] == 0) {
				res[count++] = i;
				visited[i] = true;
			}
		}
		for (int i = 0; i < numCourses; i++) {
			for (int j : list.get(res[i])) {
				if (visited[j]) return new int[0];
				if (--linkCount[j] == 0) {
					res[count++] = j;
					visited[j] = true;
				}
			}
		}
		if (count < numCourses) return new int[0];
		return res;
	}
}
