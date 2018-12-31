/**
 * 作者: 和志刚
 * 日期: 2018年11月12日
 * 时间: 下午12:27:00
 */
package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 847. Shortest Path Visiting All Nodes
 * https://leetcode.com/zhangjiashen/
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/discuss/135686/Java-DP-Solution
 * Using a two-dimensional matrix to record the distance from a point through those points.
 * Example:
 * dp[0][3(00000...00011)] = 2 means the distance starting point 0 through 0, 1 is 2
 * dp[1][7(00000...00111)] = 3 means the distance starting point 1 through 0, 1, 2 is 3.
 * After BFS, we will know the distance through all nodes, compare dp[0][11111...11111](it means that start point 0 through all nodes), dp[1][11111...11111]
 * ..., dp[n-1][11111...11111], we will get the result.
 */
public class ShortestPathVisitingAllNodes {
	
    public int shortestPathLength(int[][] graph) {
    	int[][] dp = new int[graph.length][1<<graph.length];
        Queue<State> queue =  new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1<<i]=0;
            queue.offer(new State(1<<i, i));
        }
        
        while (!queue.isEmpty()) {
            State state = queue.poll();
            
            for (int next : graph[state.source]) {
                int nextMask = state.mask | 1 << next;
                if (dp[next][nextMask] > dp[state.source][state.mask]+1) {
                    dp[next][nextMask] = dp[state.source][state.mask]+1;
                    queue.offer(new State(nextMask, next));
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            res = Math.min(res, dp[i][(1<<graph.length)-1]);
        }
        return res;
    }
    
    class State {
		public int mask, source;
		public State(int m, int s) {
			mask=m;
			source=s;
		}
	}    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShortestPathVisitingAllNodes dp = new ShortestPathVisitingAllNodes();
		int[][] graph = {{1,2,3},{0},{0},{0}};
		int N = graph.length;
		System.out.println(N+","+(1<<N));
		System.out.println( dp.shortestPathLength(graph) );
		
		int[][] graph2 = {{1},{0,2,4},{1,3,4},{2},{1,2}};
		int N2 = graph2.length;
		System.out.println(N2+","+(1<<N2));
		System.out.println( dp.shortestPathLength(graph2) );
	}

}