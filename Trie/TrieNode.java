package Trie;

public class TrieNode {

    private int ALPHABET_SIZE = 26;
    TrieNode[] childs;
    public boolean isEnd;
    public int wordEndingCount;
    public String str;

    TrieNode(){
        isEnd = false;
        wordEndingCount = 0;
        childs = new TrieNode[ALPHABET_SIZE];
        str = new String();
    }

}
