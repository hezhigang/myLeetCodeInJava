package com.leetcode;

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 * done by ChatGPT
 * Date: May 28, 2025
 * Runtime 32ms Beats 93.56%
 * Memory 55.27MB Beats 84.67%
 */
public class PrefixTree {

    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26]; // For 26 lowercase English letters
            isEndOfWord = false;
        }
    }

    private final TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    // Returns true if the word is in the trie
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }

    // Returns true if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    // Helper method to traverse the trie
    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }

    public static void main(String[] args) {
        PrefixTree trie = new PrefixTree();
        trie.insert("apple");
        trie.search("apple"); // return True
        trie.search("app"); // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app"); // return True
    }
}