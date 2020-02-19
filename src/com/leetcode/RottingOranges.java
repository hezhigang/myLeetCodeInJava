/**
 * 994. Rotting Oranges
 * https://leetcode.com/problems/rotting-oranges/
 */
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hezhigang
 *
 */
public class RottingOranges {
	
	final static int d[][] = {
			{0,1},  //right
			{1,0},  //down
			{0,-1}, //left
			{-1,0}  //up
	};
	
    public static int orangesRotting(int[][] grid) {
        for(int i=0;i<grid.length;i++) {
        	for (int j=0;j<grid[i].length;j++) {
        		System.out.printf("[%d][%d]=%d ", i, j, grid[i][j]);
        	}
        	System.out.println();	
        }
        
        int h = grid.length;
        int w = grid[0].length;

        Queue<Node> queue = new LinkedList<Node>();
        
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
            	if (grid[i][j] == 2) {
            		queue.add(new Node(new Point(i,j),0));
            	}
                
            }
        }
        
        int ans = 0;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int row = curr.pt.x;
            int col = curr.pt.y;

			for (int i = 0; i < 4; i++) {
				int x = row + d[i][0];
				int y = col + d[i][1];
				if (isValid(grid, h, w, x, y)) {
					grid[x][y] = 2;
					queue.add(new Node(new Point(x, y), curr.dist + 1));
					ans = curr.dist + 1;
				}
			}
        }
        
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		
        return ans;
    }
    
	private static boolean isValid(int[][] grid, int width, int height, int row, int col) {
		return (row >= 0) && (row < width) && (col >= 0) && (col < height) && grid[row][col]==1;
	}

	public static void main(String[] args) {
		int[][] grid = {
				{ 2, 1, 1 }, 
				{ 1, 1, 0 }, 
				{ 0, 1, 1 } 
		};
		
//		int[][] grid = {
//				{ 2, 1, 1 }, 
//				{ 0, 1, 1 }, 
//				{ 1, 0, 1 } 
//		};
		
//		int[][] grid = {
//				{0, 2}
//		};
		
		int r = orangesRotting(grid);
		System.out.printf("r=%d", r);
	}
	
	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Node {
		Point pt;
		int dist;

		public Node(Point pt, int dist) {
			this.pt = pt;
			this.dist = dist;
		}
	}

}