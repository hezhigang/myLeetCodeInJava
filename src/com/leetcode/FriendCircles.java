package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 547. Friend Circles
 * https://leetcode.com/problems/friend-circles/
 * DFS, union-find
 */
public class FriendCircles {

    /**
     * Depth-first search
     * @param M
     * @return
     */
    public static int findCircleNum_dfs(int[][] M) {
        int N = M.length;
        List<Edge> edges = new ArrayList<Edge>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if (M[i][j]==1) {
                    edges.add( new Edge(i,j) );
                    edges.add( new Edge(j,i) );
                }
            }
        }
        Graph graph = new Graph(edges, N);
        boolean[] visited = new boolean[N];
//        Arrays.fill(visited, false);
        for(int i=0; i<N; i++)
            visited[i] = false;
        int r = 0;
        for(int i=0; i<N; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                r++;
            }
        }

        return r;
    }

    private static void dfs(Graph graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int u : graph.adjList.get(v)) {
            if (!visited[u])
                dfs(graph, u, visited);
        }
    }

    /**
     * Union-Find, by Robert Sedgewick & Kevin Wayne
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        int N = M.length;
        UF uf = new UF(N);
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if (M[i][j]==1)
                    uf.union(i,j);
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] M = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        Stream.of(M).map(Arrays::toString).forEach(System.out::println);
        System.out.printf("the total number of friend circles among all the students is %d", findCircleNum(M));
        System.out.println();
        System.out.printf("the total number of friend circles by depth first search is %d", findCircleNum_dfs(M));
    }
}