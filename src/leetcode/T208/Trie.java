package leetcode.T208;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    Map<Character,Trie> map;
    boolean end;

    public Trie() {
        this.map = new HashMap<>();
        this.end = false;
    }

    public void insert(String word) {
        Trie curTrie = this;
        for(int i = 0;i<word.length();i++){
            curTrie.map.putIfAbsent(word.charAt(i),new Trie());
            curTrie = curTrie.map.get(word.charAt(i));
        }
        curTrie.end=true;
    }

    public boolean search(String word) {
        Trie curTrie = this;
        for(int i = 0;i<word.length();i++){
            if(curTrie.map.containsKey(word.charAt(i))){
                curTrie = curTrie.map.get(word.charAt(i));
                continue;
            }
            return false;
        }
        return curTrie.end;
    }

    public boolean startsWith(String prefix) {
        Trie curTrie = this;
        for(int i = 0;i<prefix.length();i++){
            if(curTrie.map.containsKey(prefix.charAt(i))){
                curTrie = curTrie.map.get(prefix.charAt(i));
                continue;
            }
            return false;
        }
        return true;
    }
}
