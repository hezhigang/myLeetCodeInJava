/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hezhigang
 * 54. Spiral Matrix
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder_my(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++) {
        	for (int j=0;j<matrix[i].length;j++) {
        		System.out.printf("[%d][%d]=%d ", i, j, matrix[i][j]);
        	}
        	System.out.println();	
        }
        int m = matrix.length;
        int n = m>0?matrix[0].length:0;
        System.out.printf("matrix:m=%d,n=%d",m,n);
        System.out.println();
        // simulation
        /*
        for(int i=0;i<n;i++) {
        	list.add(new Integer(matrix[0][i]));
        }
        for(int i=1;i<m;i++) {
        	list.add(new Integer(matrix[i][n-1]));
        }
        for(int i=n-2;i>=0;i--) {
        	list.add(new Integer(matrix[m-1][i]));
        }
        for(int i=m-2;i>0;i--) {
        	list.add(new Integer(matrix[i][0]));
        }
        for(int i=1;i<n-1;i++) {
        	list.add(new Integer(matrix[1][i]));
        }
        */
        // algorithms
        for(int delta=0;delta<Math.ceil(Math.min(m, n)/2)+1;delta++) {
        	for(int i=delta;m>=2*delta+1 && i<n-delta;i++) {
            // for(int i=delta;i<n-delta;i++) {
            	list.add(new Integer(matrix[delta][i]));
            }
            for(int i=delta+1;n>=2*delta+1 && i<m-delta;i++) {
            // for(int i=delta+1;i<m-delta;i++) {
            	list.add(new Integer(matrix[i][n-delta-1]));
            }
            //if (m<n && 2*delta+2==n) break;
            //if (m<2*delta+2) break;
            for(int i=n-delta-2;m>=2*delta+2 && i>=delta;i--) {
            // for(int i=n-delta-2;i>=delta;i--) {
            	list.add(new Integer(matrix[m-delta-1][i]));
            }
            for(int i=m-delta-2;n>=2*delta+2 && i>delta;i--) {
            //for(int i=m-delta-2;i>delta;i--) {
            	list.add(new Integer(matrix[i][delta]));
            } 	
        }
        return list;
    }
    
    /**
     * 顺时针螺旋矩阵
     * 盘点今年秋招那些“送命”的算法面试题 - 极客大学 - InfoQ
     * @param matrix
     * @return
     */
	public static List<Integer> spiralOrder(int[][] matrix) {
		/**
		 * 核心思想是，由起点坐标、方向、位移可以定义矩阵中的唯一一条线段，
		 * 并且可知当前路径下的所有坐标；
		 * 而螺旋的过程可以抽象为访问多条首尾相连的线段
		 * 我们可以根据初始起点坐标、方向、位移，螺旋得到矩阵中所有坐标。
		 */
		List<Integer> result = new ArrayList<>();
		int height = matrix.length, width = height == 0 ? 0 : matrix[0].length;
		int size = height * width;

		int[] dirX = { 0, 1, 0, -1 };
		int[] dirY = { 1, 0, -1, 0 };

		// 初始化起点坐标:(0,-1) 方向:向右;
		int x = 0, y = -1, dir = 0;
		for (int step, total = 0; total < size; total += step) {

			// 根据方向得到对应的位移, 并修正此后矩阵的参数(此后线段的长度)
			if (dir == 0 || dir == 2) {
				step = width;
				height--;
			} else {
				step = height;
				width--;
			}
			// 此前确定了起点坐标、方向和位移, 就可以得到当前线段的所有坐标,并输出到结果集;
			for (int i = step; i > 0; i--) {
				x += dirX[dir];
				y += dirY[dir];
				result.add(matrix[x][y]);
			}
			// 调整下一条线段方向
			dir = ++dir % 4;
		}
		return result;
	}    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		
		//int[][] matrix = { {6,7} };
		
		//int[][] matrix = { {1,2}, {3,4} };
		
		//int[][] matrix = { {6}, {7} };
		
		//int[][] matrix = { {1} };
		
		//int[][] matrix = { {1, 2}, {3, 4}, {5, 6} };
		
		//int[][] matrix = { {} };
		//int[][] matrix = {};
		
		//int[][] matrix = {{6,9,7}};
		
		//int[][] matrix = { {7},{9},{6} };
		
		//int[][] matrix = { {2,5,8},{4,0,-1}};
		
		//int[][] matrix = { {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16} };
		
		//int[][] matrix = { {8,1,6}, {3,5,7}, {4,9,2} };
		
		//int[][] matrix = { {1,15,14,4}, {12,6,7,9}, {8,10,11,5}, {13,3,2,16} };

		System.out.println(Arrays.deepToString(matrix));

		Stream.of(matrix).map(Arrays::toString).forEach(System.out::println);
		
		List<Integer> list = spiralOrder(matrix);
		System.out.println("["+list.stream().map(Object::toString).collect(Collectors.joining(","))+"]");
	}

}