package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        boolean r = true;
        Map<Character,Character> map = new HashMap<Character, Character>();
        Map<Character,Character> map2 = new HashMap<Character, Character>();
        for(int i=0; i<s.length(); i++) {
            char k = s.charAt(i);
            char x = t.charAt(i);
            if (map.containsKey(k)) {
                char v = map.get(k);
                if (x!=v) {
                    return false;
                }
            }
            else {
                map.put(k,x);
            }
            if (map2.containsKey(x)) {
                char v = map2.get(x);
                if (k!=v) {
                    return false;
                }
            }
            else {
                map2.put(x, k);
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        String s = "egg", t = "add";
//        String s = "foo", t = "bar";
//        String s = "paper", t = "title";
        String s = "ab", t = "aa";
//        String s = "ab", t = "ca";
        System.out.printf("%s %s isomorphic with %s", s, isIsomorphic(s,t)?"are":"are not", t);
    }
}
