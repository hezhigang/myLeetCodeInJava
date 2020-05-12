/**
 * Union find, DFS, BFS
 */
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hezhigang
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIslands {

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

        Queue<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    queue.add(new Integer[]{i,j});
                    BFS(queue, grid, visited);
                    r++;
                }
            }
        }
        
    	return r;
    }
    
    public static void BFS(Queue<Integer[]> queue, char[][] islandGrid, boolean[][] visited) {

        int H = islandGrid.length;
        int L = islandGrid[0].length;

        while (queue.isEmpty() == false) {

            Integer[] x = queue.remove();
            int row = x[0];
            int col = x[1];

            if(row<0 || col<0 || row>=H || col>=L || visited[row][col] || islandGrid[row][col]!='1')
                continue;

            visited[row][col]=true;
            queue.add(new Integer[]{row, (col-1)}); //go left
            queue.add(new Integer[]{row, (col+1)}); //go right
            queue.add(new Integer[]{(row-1), col}); //go up
            queue.add(new Integer[]{(row+1), col}); //go down
        }
    }

    public static void main(String[] args) {
        char[][] grid0 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };

        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        int c = numIslands(grid);

        System.out.printf("Number of Islands is %d", c);
    }
}