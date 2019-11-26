/**
 * Topological Sort Algorithm for DAG using DFS
 * https://www.techiedelight.com/topological-sorting-dag/
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author hezhigang
 * 210. Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseSchedule2 {
	
	/**
	 * Perform DFS on graph and set departure time of all vertices of the graph
	 * @param graph
	 * @param v
	 * @param discovered
	 * @param departure
	 * @param time
	 * @return
	 */
	private static int DFS(Graph graph, int v, boolean[] discovered, int[] departure, int time) {
		// mark current node as discovered
		discovered[v] = true;

		// do for every edge (v -> u)
		for (int u : graph.adjList.get(v)) {
			// u is not discovered
			if (!discovered[u])
				time = DFS(graph, u, discovered, departure, time);
		}

		// ready to backtrack
		// set departure time of vertex v
		departure[v] = time++;

		return time;
	}
	
	// performs Topological Sort on a given DAG, it has bug
	public static void doTopologicalSort(Graph graph, int N) {
		// departure[] stores the vertex number using departure time as index
		int[] departure = new int[2 * N];
		Arrays.fill(departure, -1);

		// Note if we had done the other way around i.e. fill the
		// array with departure time by using vertex number
		// as index, we would need to sort the array later

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];
		int time = 0;

		// perform DFS on all undiscovered vertices
		for (int i = 0; i < N; i++) {
			if (!discovered[i]) {
				time = DFS(graph, i, discovered, departure, time);
			}
		}

		// Print the vertices in order of their decreasing
		// departure time in DFS i.e. in topological order
		for (int i = 2 * N - 1; i >= 0; i--) {
			if (departure[i] != -1) {
				System.out.print(departure[i] + " ");
			}
		}
	}
	
	public static boolean isDAG(Graph graph, int N) {
		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// stores departure time of a vertex in DFS
		int[] departure = new int[N];

		int time = 0;

		// Do DFS traversal from all undiscovered vertices
		// to visit all connected components of graph
		for (int i = 0; i < N; i++)
			if (discovered[i] == false)
				time = DFS(graph, i, discovered, departure, time);

		// check if given directed graph is DAG or not
		for (int u = 0; u < N; u++) {
			// check if (u, v) forms a back-edge.
			for (int v : graph.adjList.get(u)) {
				// If departure time of vertex v is greater
				// than equal to departure time of u, then
				// they form a back edge

				// Note that departure[u] will be equal to
				// departure[v] only if u = v i.e vertex
				// contain an edge to itself
				if (departure[u] <= departure[v])
					return false;
			}
		}

		// no back edges
		return true;
	}	
	
    public static int[] findOrder_bug(int numCourses, int[][] prerequisites) {
        int[] tp = new int[numCourses];
        
        List<Integer> tplist = new ArrayList<Integer>();
    	List<Edge> edges = new ArrayList<Edge>();
    	for(int i=0; i<prerequisites.length; i++) {
    		edges.add(new Edge(prerequisites[i][0],prerequisites[i][1]));
    	}
    	Graph graph = new Graph(edges, numCourses);
    	
    	if (!isDAG(graph, numCourses))
    			return new int[]{};
        
		// departure[] stores the vertex number using departure time as index
		int[] departure = new int[2 * numCourses];
		Arrays.fill(departure, -1);

		// Note if we had done the other way around i.e. fill the
		// array with departure time by using vertex number
		// as index, we would need to sort the array later

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[numCourses];
		int time = 0;

		// perform DFS on all undiscovered vertices
		for (int i = 0; i < numCourses; i++) {
			if (!discovered[i]) {
				time = DFS(graph, i, discovered, departure, time);
			}
		}

		// Print the vertices in order of their decreasing
		// departure time in DFS i.e. in topological order
		for (int i = 2 * numCourses - 1; i >= 0; i--) {
			if (departure[i] != -1) {
//				System.out.print(departure[i] + " ");
				tplist.add(departure[i]);
			}
		}    
		Collections.reverse(tplist);
		for(int i=0; i<tplist.size();i++)
			tp[i] = tplist.get(i);
        return tp;
    }
    
    /**
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] tp = new int[numCourses];
        
    	List<Edge> edges = new ArrayList<Edge>();
    	for(int i=0; i<prerequisites.length; i++) {
    		edges.add(new Edge(prerequisites[i][0],prerequisites[i][1]));
    	}
    	Graph graph = new Graph(edges, numCourses);
    	
    	if (!isDAG(graph, numCourses))
    			return new int[]{};
    	
    	List<Integer> tplist = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		boolean visited[] = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
			visited[i] = false;

		for (int i = 0; i < numCourses; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack, graph);
		while (stack.empty() == false)
			tplist.add( stack.pop() );
		
		Collections.reverse(tplist);
		for(int i=0; i<tplist.size();i++)
			tp[i] = tplist.get(i);
    	
        return tp;
    }    
    
	 static void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack, Graph graph) {
		// Mark the current node as visited. 
		visited[v] = true;
		Integer i;
		
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> it = graph.adjList.get(v).iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i])
				topologicalSortUtil(i, visited, stack, graph);
		}
		
		// Push current vertex to stack which stores result 
		stack.push(new Integer(v));
	}
	
	static void topologicalSort(Graph graph, int V) {
		Stack stack = new Stack();

		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		// Call the recursive helper function to store
		// Topological Sort starting from all vertices
		// one by one
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack, graph);

		// Print contents of stack
		while (stack.empty() == false)
			System.out.print(stack.pop() + " ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// List of graph edges as per above diagram
//		List<Edge> edges = Arrays.asList(new Edge(1, 0), new Edge(2, 0), new Edge(3, 1), new Edge(3, 2));
		List<Edge> edges = Arrays.asList(new Edge(1, 0), new Edge(0, 3), new Edge(0, 2), new Edge(3, 2), 
				new Edge(2, 5), new Edge(4, 5), new Edge(5, 6), new Edge(2, 4));

		// Set number of vertices in the graph
//		final int N = 4;
		final int N = 7;

		// create a graph from edges
		Graph graph = new Graph(edges, N);

		// perform Topological Sort
		System.out.println("doTopologicalSort--bug-->");
		doTopologicalSort(graph, N);
		
		System.out.println();
		
		System.out.println("topologicalSort--OK-->");
		topologicalSort(graph, N);
		
		System.out.println();
		
//		int numCourses = 4;
//		int[][] prerequisites = { {1,0},{2,0},{3,1},{3,2} };
//		int numCourses = 2;
//		int[][] prerequisites = { {1,0} };
//		int numCourses = 2;
//		int[][] prerequisites = { {0,1},{1,0} };
		int numCourses = 7;
		int[][] prerequisites = { {1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4} };		
		int[] tp = findOrder(numCourses, prerequisites);
		for(int i=0;i<tp.length;i++)
			System.out.print(tp[i]+" ");
	}

}