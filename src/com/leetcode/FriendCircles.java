package com.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 547. Friend Circles
 * https://leetcode.com/problems/friend-circles/
 * DFS, union-find
 */
public class FriendCircles {

    public static int findCircleNum(int[][] M) {
        int N = M.length;
        UF uf = new UF(N);
        for(int i=0; i<N; i++) {
            for(int j=0; j<=i; j++) {
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
    }
}

/**
 * Weighted quick-union by rank with path compression by halving.
 * @author Robert Sedgewick
 * @author Kevin Wayne
 * Algorithms, 4th edition textbook code and libraries
 * https://github.com/kevin-wayne/algs4
 */
class UF {
    private int[] parent;
    private byte[] rank;
    private int count;

    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }
}