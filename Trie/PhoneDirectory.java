package Trie;

import java.util.ArrayList;

public class PhoneDirectory {

    private ArrayList<String> contacts;
    private TrieNode root;
    public PhoneDirectory(String[] contacts){
        this.contacts = new ArrayList<>();
        for(String con : contacts){
            this.contacts.add(con);
        }
        this.root = new TrieNode();
        createTrie(root,this.contacts);
    }

    private void createTrie(TrieNode root, ArrayList<String> contacts) {
        TrieNode cur;

        for(String con : contacts){
            cur = root;
            for(char letter : con.toCharArray()){
                if(cur.childs[letter - 'a'] == null){
                    cur.childs[letter - 'a'] = new TrieNode();
                }

                cur = cur.childs[letter - 'a'];
            }

            cur.isEnd = true;
            cur.str = con;
        }
    }

    public void query(String word) {
        if(word.length() == 0){
            //display all contacts
            return;
        }

        TrieNode cur = root;

        for(char letter : word.toCharArray()){
            if(cur.childs[letter - 'a'] == null){
                System.out.println("No contacts Found");
                return;
            }
            cur = cur.childs[letter - 'a'];
        }

        if(cur.isEnd){
            System.out.println(cur.str);
            return;
        }

//        int letterNo = 0;
//        for(TrieNode option : cur.childs){
//            if(option != null)
//                dfs(option,"",'a'+ letterNo);
//
//            letterNo++;
//        }

        for(int i = 0;i < 26;i++){
            char ch = (char)(i + 'a');
            if(cur.childs[ch - 'a'] != null){
                dfs(cur.childs[ch - 'a']);
            }
        }
        return;
    }

    private void dfs(TrieNode node){
        if(node == null) return;
        if(node.isEnd){
            System.out.println(node.str);
        }

        for(TrieNode option : node.childs){
            if(option != null){
                dfs(option);
            }
        }
        return;
    }
    public static void main(String[] args) {
        String[] contacts = new String[]{"harshit","harsh","harshita","harry","samay","sam","vitalik"};
        PhoneDirectory pd = new PhoneDirectory(contacts);
        pd.query("har");
        pd.query("p");
        pd.query("vr");
    }
}
