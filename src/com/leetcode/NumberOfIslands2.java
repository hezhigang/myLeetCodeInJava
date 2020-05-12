/**
 * Union find, DFS, BFS
 */
package com.leetcode;

import java.util.*;

/**
 * @author hezhigang
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands2 {
	
	final static int d[][] = {
			{0,1},  //right
			{1,0},  //down
			{0,-1}, //left
			{-1,0}  //up
	};

	/**
	 * Number of Islands using BFS
	 * https://algorithms.tutorialhorizon.com/number-of-islands-using-bfs/
	 * @param grid
	 * @return
	 */
    public static int numIslands(char[][] grid) {
        for(int i=0;i<grid.length;i++) {
        	for (int j=0;j<grid[i].length;j++) {
        		System.out.printf("[%d][%d]=%c ", i, j, grid[i][j]);
        	}
        	System.out.println();
        }
        
        int h = grid.length;
        if (h == 0)
            return 0;
        int w = grid[0].length;
        
        int r = 0;

        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                visited[i][j] = false;
            }
        }

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    queue.add(new Point(i,j));
                    bfs(queue, grid, visited);
                    r++;
                }
            }
        }
        
    	return r;
    }
    
    public static void bfs(Queue<Point> queue, char[][] islandGrid, boolean[][] visited) {

        int h = islandGrid.length;
        int w = islandGrid[0].length;

        while (queue.isEmpty() == false) {
        	Point curr = queue.poll();
            int row = curr.x;
            int col =  curr.y;
            if (isValid(islandGrid, visited, h, w, row, col)) {
                visited[row][col]=true;
				for (int i = 0; i < 4; i++) {
					int x = curr.x + d[i][0];
					int y = curr.y + d[i][1];
					queue.add(new Point(x, y));
				}
            }
        }
    }
    
	private static boolean isValid(char[][] grid, boolean[][] visited, int width, int height, int row, int col) {
		return (row >= 0) && (row < width) && (col >= 0) && (col < height) && grid[row][col] == '1' && !visited[row][col];
	}

	private static boolean isValid(char[][] grid, int width, int height, int row, int col) {
		return (row >= 0) && (row < width) && (col >= 0) && (col < height) && grid[row][col] == '1';
	}

	public static int numIslands_uf(char[][] grid) {
		int h = grid.length;
		if (h == 0)
			return 0;
		int w = grid[0].length;

		int N = 0;
		List<Point> ptlist = new ArrayList<Point>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (grid[i][j] == '1') {
					Point pt = new Point(i,j);
					ptlist.add(pt);
					map.put(i+","+j, N++);
				}
			}
		}

		UF uf = new UF(N);
		for (int i = 0; i < N; i++) {
			Point curr = ptlist.get(i);
			int row = curr.x;
			int col = curr.y;
			for (int k = 0; k < 4; k++) {
				int x = row + d[k][0];
				int y = col + d[k][1];
				if (isValid(grid, h, w, x, y)) {
					uf.union(i, map.get(x + "," + y));
				}
			}
		}

		return uf.count();
	}

	public static void main(String[] args) {
		char[][] grid0 = {
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}
		};
		
		char[][] grid = {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}
		};

		char[][] grid1 = {};

		char[][] grid2 = {
				{ '1', '1', '1' },
				{ '0', '1', '0' },
				{ '1', '1', '1' } };

		char[][] grid3 = {
				{ '1', '0', '1', '1', '1' },
				{ '1', '0', '1', '0', '1' },
				{ '1', '1', '1', '0', '1' } };

		int c = numIslands(grid0);

		int c2 = numIslands_uf(grid0);
		
		System.out.printf("Number of Islands is %d", c);
		System.out.println();
		System.out.printf("Number of Islands is %d", c2);
		
	}
	
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}