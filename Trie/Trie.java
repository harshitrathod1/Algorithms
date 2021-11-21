package Trie;

public class Trie {

    public  TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){

        TrieNode cur = root;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);

            if(cur.childs[ch - 'a'] == null){
                cur.childs[ch - 'a'] = new TrieNode();
            }

            cur = cur.childs[ch - 'a'];
        }

        cur.isEnd = true;

        //handles duplicates in a collection
        cur.wordEndingCount++;
    }

    public boolean search(String word){
        TrieNode cur = root;

        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);

            if(ch - 'a' > 26 || ch - 'a' < 0) return false;

            if(cur.childs[ch -'a'] == null) return false;

            cur = cur.childs[ch -'a'];
        }

        return cur.isEnd;
    }

    public boolean startsWith(String word){
        TrieNode cur = root;

        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);

            if(cur.childs[ch - 'a'] == null) return false;

            cur = cur.childs[ch - 'a'];
        }

        return true;
    }


}
