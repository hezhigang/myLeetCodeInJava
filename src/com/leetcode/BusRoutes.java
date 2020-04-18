package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hezhigang
 * 815. Bus Routes
 * https://leetcode.com/problems/bus-routes/
 */
public class BusRoutes {

    public static boolean routesIntersect(int[] route1, int[] route2) {
        boolean r = false;
        Set<Integer> tmpSet = new HashSet<Integer>();
        for(int i=0; i<route1.length; i++)
            tmpSet.add(route1[i]);
        for(int i=0; i<route2.length; i++) {
            if (tmpSet.contains(route2[i])) {
                r = true;
                break;
            }
        }
        return r;
    }

    public static boolean inArray(int[] a, int x) {
        boolean b = false;
        for(int i=0; i<a.length; i++) {
            if (x==a[i]) {
                b = true;
                break;
            }
        }
        return b;
    }

    /**
     * Time Limit Exceeded
     * @param a
     * @param x
     * @return
     */
    public static boolean inArray2(int[] a, int x) {
        Set<Integer> set = new HashSet<Integer>(Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new)));
        return set.contains(x);
    }

    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        int minDist = Integer.MAX_VALUE;

        int h = routes.length;

        List<Integer> list_S = new ArrayList<Integer>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (routes[i][j]==S) {
                    list_S.add(i);
                }
            }
        }

        System.out.println(list_S.stream().map(Object::toString).collect(Collectors.joining(",")));

        Map<Integer, List<Integer>> reachableRouteMap = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<h; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j=0; j<h; j++) {
                if (j!=i && routesIntersect(routes[i],routes[j])) {
                    list.add(j);
                }
            }
            reachableRouteMap.put(i,list);
        }

        System.out.print(reachableRouteMap);
        System.out.println();

        boolean[] visited = new boolean[h];
        for (int i = 0; i < h; i++) {
            visited[i] = false;
        }

        Queue<Node> q = new LinkedList<>();
        for(Integer i : list_S) {
            Node s = new Node(i, 1);
            q.add(s);
        }

        while (!q.isEmpty()) {
            Node curr = q.poll();
            visited[curr.route] = true;
            if (inArray(routes[curr.route], T)) {
                return curr.dist;
            }
            List<Integer> list = reachableRouteMap.get(curr.route);
            for(Integer idx : list) {
                if (visited[idx]==false) {
                    Node node = new Node(idx, curr.dist+1);
                    q.add(node);
                }
            }
        }

        if (minDist == Integer.MAX_VALUE)
            minDist = -1;
        return minDist;
    }

    public static void main(String[] args) {
//        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
//        int S = 1, T = 6;
//        int[][] routes = {{7,12},{4,5,15},{6},{15,19},{9,12,13}};
//        int S = 15, T =12;
//        int[][] routes = {{1,7},{3,5}};
//        int S = 5, T = 5;
        int[][] routes = {{3, 8, 17, 21, 34, 36, 43, 47, 54, 58, 69, 82, 93, 95, 97, 102, 106, 108, 112, 114, 119, 126, 131, 132, 136, 150, 159, 160, 166, 176, 182, 188, 194}, {12, 27, 33, 67, 77, 86, 101, 144, 176, 190, 192}, {12, 14, 24, 36, 44, 47, 59, 62, 71, 74, 77, 80, 100, 113, 114, 117, 187, 193, 195}, {2, 4, 30, 40, 41, 46, 67, 77, 85, 86, 101, 106, 135, 136, 148, 156, 169, 171, 186, 193}, {0, 4, 11, 14, 18, 21, 27, 37, 38, 44, 53, 65, 75, 93, 94, 98, 101, 114, 117, 130, 131, 132, 141, 144, 145, 167, 185, 188}, {7, 21, 23, 31, 63, 82, 100, 106, 112, 114, 163}, {16, 17, 29, 41, 58, 62, 72, 74, 94, 102, 106, 120, 151, 152, 161, 163, 195}, {5, 7, 11, 12, 26, 27, 42, 50, 68, 72, 75, 76, 86, 89, 92, 100, 102, 111, 113, 121, 129, 133, 138, 143, 145, 150, 168, 169, 175, 184, 185, 188, 195, 202}, {2, 11, 13, 20, 25, 28, 30, 35, 40, 42, 43, 67, 75, 77, 80, 81, 83, 100, 101, 102, 110, 116, 134, 138, 139, 140, 142, 150, 153, 159, 167, 174, 176, 178, 184}, {13, 22, 78, 93, 120, 151, 178, 189}, {16, 21, 38, 40, 79, 87, 88, 96, 114, 134, 145, 155, 157, 159, 165, 201}, {4, 12, 28, 30, 35, 37, 45, 46, 65, 70, 72, 75, 86, 103, 116, 137, 157, 163, 166, 169, 196, 197, 200}, {22, 24, 29, 34, 35, 38, 42, 48, 68, 75, 81, 99, 107, 118, 123, 140, 141, 155, 158, 160, 167, 177, 180, 182, 185, 190, 195, 197, 202}, {23}, {2, 26, 74, 111, 113, 134, 149, 150, 182, 188}, {0, 15, 35, 63, 68, 79, 80, 85, 92, 104, 138, 141, 146, 193, 194, 198}, {6, 7, 11, 13, 20, 23, 29, 31, 32, 37, 46, 47, 49, 70, 73, 75, 80, 108, 112, 123, 127, 131, 132, 139, 144, 149, 150, 176, 179, 193, 194, 196, 197}, {132}, {16, 20, 22, 24, 35, 40, 43, 55, 65, 78, 80, 105, 113, 119, 137, 146, 158, 165, 184, 190, 198}, {0, 1, 6, 11, 12, 15, 22, 24, 25, 33, 35, 39, 65, 66, 73, 76, 77, 81, 83, 97, 98, 99, 100, 101, 109, 111, 120, 131, 143, 151, 173, 184, 190, 192}, {0, 1, 9, 10, 22, 24, 35, 39, 48, 53, 56, 58, 69, 73, 78, 104, 116, 117, 120, 129, 131, 135, 139, 151, 153, 163, 166, 169, 170, 179, 187, 193}, {1, 22, 30, 31, 32, 48, 50, 53, 57, 59, 61, 65, 71, 73, 76, 78, 80, 96, 98, 106, 110, 111, 113, 117, 131, 132, 134, 135, 137, 140, 152, 160, 170, 183, 186, 191, 200}, {12, 13, 22, 30, 35, 46, 53, 67, 86, 92, 95, 98, 100, 101, 104, 106, 117, 133, 141, 146, 149, 158, 159, 163, 164, 167, 181, 189, 190, 199, 200}, {6, 65, 155, 157, 171, 177, 184}, {5, 16, 31, 47, 57, 69, 77, 78, 82, 97, 115, 146, 172, 173, 190}, {41, 54, 91}, {3, 46, 68, 81, 92, 96, 103, 104, 111, 121, 136, 147, 157, 171, 190, 193, 198}, {22, 48, 94, 126, 138, 139}, {194}, {4, 8, 20, 22, 38, 41, 45, 46, 54, 55, 61, 79, 80, 85, 90, 93, 115, 128, 132, 135, 139, 140, 150, 158, 159, 166, 168, 169, 179, 181, 182, 190}, {1, 2, 16, 17, 20, 28, 37, 41, 44, 45, 54, 55, 56, 59, 68, 72, 74, 75, 88, 100, 103, 126, 159, 166, 172, 175, 187, 188, 191}, {15, 34, 48, 52, 69, 87, 93, 105, 147, 190, 204}, {9, 22, 85, 124, 141, 176, 193}, {17, 22, 28, 33, 34, 36, 43, 69, 70, 72, 81, 103, 111, 128, 129, 142, 154, 155, 156, 157, 172, 178, 183, 190, 191, 200}, {14, 16, 23, 25, 30, 43, 44, 51, 56, 69, 70, 79, 85, 86, 90, 91, 92, 100, 117, 129, 139, 141, 144, 157, 159, 171, 174, 176, 182, 184, 196, 204}, {16, 45, 52, 56, 79, 122, 132, 154, 162, 163, 172, 197}, {0, 7, 30, 37, 38, 41, 45, 47, 57, 67, 91, 92, 105, 110, 146, 147, 150, 153, 158, 170, 174, 176, 181, 182, 189, 193}, {2, 3, 13, 22, 25, 38, 39, 40, 43, 53, 56, 61, 66, 69, 76, 78, 82, 85, 86, 113, 115, 118, 132, 141, 147, 152, 156, 157, 162, 184, 199, 203}, {7, 8, 17, 19, 38, 44, 54, 73, 74, 77, 82, 85, 88, 91, 94, 100, 101, 102, 104, 108, 112, 122, 125, 128, 135, 147, 156, 157, 167, 173, 184, 190, 196, 202}, {29, 78, 125}, {35, 36, 38, 105, 129, 132, 139, 154, 189, 202}};
        int S = 44, T = 139;
        int len = numBusesToDestination(routes, S, T);
        System.out.printf("the least number of buses we must take to reach our destination=%d", len);
    }

    static class Node {
        int route;
        int dist;

        public Node(int route, int dist) {
            this.route = route;
            this.dist = dist;
        }
    }
}