/**
 * Lee algorithm
 * maze routing problems
 * Breadth-first search
 */
package com.alg.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hezhigang
 * Shortest path in a Maze | Lee algorithm
 * https://www.techiedelight.com/lee-algorithm-shortest-path-in-a-maze/
 * 
 * Shortest path in a Binary Maze
 * https://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
 */
public class LeeAlgorithm {
	// move direction
	final static int d[][] = {
			{0,1},  //right
			{1,0},  //down
			{0,-1}, //left
			{-1,0}  //up
	};

	public static int bfs(int[][] maze, Point src, Point dest) {
		int minDist = Integer.MAX_VALUE;
		
	    if (maze[src.x][src.y] != 1 || maze[dest.x][dest.y] != 1) 
	    	return minDist;

		int h = maze.length;
		int w = maze[0].length;
		boolean[][] visited = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				visited[i][j] = false;
			}
		}

		Queue<Node> q = new LinkedList<>();
		Node s = new Node(src, 0);
		q.add(s);

		while (!q.isEmpty()) {
			Node curr = q.poll();
			Point pt = curr.pt;
			if (pt.x == dest.x && pt.y == dest.y)
				return curr.dist;
			for (int i = 0; i < 4; i++) {
				int row = pt.x + d[i][0];
				int col = pt.y + d[i][1];
				if (isValid(maze, visited, h, w, row, col)) {
					visited[row][col] = true;
					Node adjCell = new Node(new Point(row, col), curr.dist + 1);
					q.add(adjCell);
				}
			}
		}
		return minDist;
	}

	private static boolean isValid(int[][] maze, boolean[][] visited, int width, int height, int row, int col) {
		return (row >= 0) && (row < width) && (col >= 0) && (col < height) && maze[row][col] == 1 && !visited[row][col];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] maze = { 
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, 
				{ 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 1 }, 
				{ 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 }, 
				{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 }, 
				{ 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 }, 
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 }, 
				{ 0, 0, 1, 0, 0, 1, 1, 0, 0, 1 } 
		};
		
//	    int maze[][] = {
//	    		{ 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, 
//                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, 
//                { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, 
//                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
//                { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, 
//                { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 }, 
//                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
//                { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
//                { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
//         };
		
		int h = maze.length;
		int w = maze[0].length;
		System.out.printf("%d*%d\n", h, w);

		Point source = new Point(0, 0);
		Point dest = new Point(7, 5);
//		Point dest = new Point(3, 4);
		int dist = bfs(maze, source, dest);

		if (dist != Integer.MAX_VALUE)
			System.out.printf("The shortest path from (%d,%d) to (%d,%d) has length %d\n", source.x, source.y, dest.x,
					dest.y, dist);
		else
			System.out.printf("Shortest path from (%d,%d) to (%d,%d) doesn't exist\n", source.x, source.y, dest.x,
					dest.y);
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