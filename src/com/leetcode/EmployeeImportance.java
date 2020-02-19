/**
 * 690. Employee Importance
 * https://leetcode.com/problems/employee-importance/
 */
package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hezhigang
 *
 */
public class EmployeeImportance {

	public static int getImportance(List<Employee> employees, int id) {
		int r = 0;

		boolean[] visited = new boolean[employees.size()];
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<employees.size(); i++) {
			Employee e = employees.get(i);
			if (e.id==id) {
				for(Integer subId:e.subordinates)
					queue.add(subId);
				r+=e.importance;
				visited[i]=true;
				break;
			}
		}

		while (!queue.isEmpty()) {
			int currId = queue.poll();
			for(int i=0; i<employees.size(); i++) {
				if (!visited[i]) {
					Employee e = employees.get(i);
					if (e.id==currId) {
						for(Integer subId:e.subordinates)
							queue.add(subId);
						r+=e.importance;
						visited[i]=true;
					}
				}
			}
		}

		return r;
	}


	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee1 = new Employee();
		employee1.id = 1;
		employee1.importance=5;
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(3);
		employee1.subordinates= list1;
		employees.add(employee1);

		Employee employee2 = new Employee();
		employee2.id = 2;
		employee2.importance=3;
		List<Integer> list2 = new ArrayList<Integer>();
		employee2.subordinates= list2;
		employees.add(employee2);

		Employee employee3 = new Employee();
		employee3.id = 3;
		employee3.importance=3;
		List<Integer> list3 = new ArrayList<Integer>();
		employee3.subordinates= list3;
		employees.add(employee3);

		System.out.println(employees.stream().map(x -> x.id+","+x.importance+","+x.subordinates).collect(Collectors.joining("\n")));

		int rootId = 1;

		int sum = getImportance(employees, rootId);

		System.out.printf("the total importance value of employee %d is %d.", rootId, sum);
	}

	// Employee info
	static class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	};

}