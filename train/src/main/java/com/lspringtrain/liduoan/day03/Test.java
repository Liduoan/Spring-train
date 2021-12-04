package com.lspringtrain.liduoan.day03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liduoan
 * @date 2021年12月04日 22:56
 */
public class Test {
    static class Trie {
        Trie[] chars;
        boolean isEnd;

        public Trie() {
            chars = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (chars[index] == null) {
                    chars[index] = new Trie();
                }
                root = chars[index];
            }
            root.isEnd = true;
        }

        public boolean search(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (chars[index] == null) {
                    return false;
                }
                root = chars[index];
            }
            return root.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie root = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (chars[index] == null) {
                    return false;
                }
                root = chars[index];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("adds");
        trie.search("ad");
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if (!map.containsKey(ch)) {
                return false;
            } else {
                Integer integer = map.get(ch);
                integer--;
                if (integer < 0) {
                    return false;
                }
                map.put(ch, integer);
            }
        }
        return true;

    }
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
