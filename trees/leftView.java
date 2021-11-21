package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class leftView {

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();

        getLeftView(root);
    }

    static void getLeftView(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        ArrayList<Integer> leftView = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                Node top = queue.poll();
                //replace i == 0 with i == size - 1 for right view
                if(i == 0){
                    leftView.add(top.val);
                }

                if(top.left != null){ queue.offer(top.left);}

                if(top.right != null) { queue.offer(top.right); }
            }
        }

        System.out.println(leftView);
    }
}
