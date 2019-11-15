/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hezhigang
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 * Given an array of strings, group anagrams together.
 */
public class GroupAnagrams {
	
    public static List<List<String>> groupAnagrams_problem(String[] strs) {
    	List<List<String>> list = new ArrayList<List<String>>();
    	Map<String,Set<Character>> map = new HashMap<String,Set<Character>>();
    	String s;
    	Set<Character> set;
    	for(int i=0;i<strs.length;i++) {
    		s = strs[i];
    		set = new HashSet<Character>();
    		for(int j=0;j<s.length();j++) {
    			set.add(s.charAt(j));
    		}
    		map.put(s, set);
    	}
    	
    	Set<Entry<String, Set<Character>>> entryset = map.entrySet();
    	System.out.println("entry size in Map:"+entryset.size());
    	for(Entry<String, Set<Character>> entry : entryset) {
    		System.out.println(entry.getKey()+"->"+entry.getValue().stream().map(Object::toString).collect(Collectors.joining(",")));
    	}
    	
		Map<Set<Character>, List<String>> result = map.entrySet().stream().collect(
				Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		System.out.println(result);
    	
        list.addAll(result.values());
        
    	return list;
    }
    
	public static List<List<String>> groupAnagrams_problem_2(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<Set<Character>, List<String>> map = new HashMap<Set<Character>, List<String>>();
		String s;
		Set<Character> set;
		for (int i = 0; i < strs.length; i++) {
			s = strs[i];
			set = new HashSet<Character>();
			for (int j = 0; j < s.length(); j++) {
				set.add(s.charAt(j));
			}
			if (map.containsKey(set)) {
				map.get(set).add(s);
			} else {
				List<String> glist = new ArrayList<String>();
				glist.add(s);
				map.put(set, glist);
			}
		}

		list.addAll(map.values());
		return list;
	}
	
	/**
	 * https://medium.com/javascript-in-plain-english/algorithms-101-group-anagrams-in-javascript-b3e3c10d211e
	 * @param strs
	 * @return
	 */
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String s;
		char[] c;
		String key;
		for (int i = 0; i < strs.length; i++) {
			s = strs[i];
			c = s.toCharArray();
			Arrays.sort(c);
			key = new String(c);
			if (map.containsKey(key)) {
				map.get(key).add(s);
			} else {
				List<String> glist = new ArrayList<String>();
				glist.add(s);
				map.put(key, glist);
			}
		}

		list.addAll(map.values());
		return list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
//		String[] arr = {"",""};
		String[] arr = { "hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve", "elf", "pup",
				"bum", "iva", "lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen", "job", "dis",
				"max", "oho", "jed", "lye", "ram", "pup", "qua", "ugh", "mir", "nap", "deb", "hog", "let", "gym", "bye",
				"lon", "aft", "eel", "sol", "jab" };
		List<List<String>> list = groupAnagrams(arr);
		System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(",")));
	}

}