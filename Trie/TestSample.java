package Trie;

public class TestSample {

    public static void main(String[] args) {
        Trie dict = new Trie();
        String[] words = new String[]{"car","cards","card","cot","cots","tried","trie"};

        for(String word : words){
            dict.insert(word);
        }

        String[] test = new String[]{"car","cots","Tried","tried"};

        for(String word : test){
            boolean ans = dict.search(word);
            System.out.print(ans + " ");
        }
        System.out.println();


        String[] test2 = new String[]{"ca","car","tri","uyt","ckt"};

        for(String word : test2){
            boolean ans = dict.startsWith(word);
            System.out.print(ans+" ");
        }
        System.out.println();
    }
}
