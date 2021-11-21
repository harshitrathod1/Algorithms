package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class diagonalOrderTraversal {

    public static void main(String[] args) {
        Node n = new Node();
        //Node root = n.getDummyTree2();
        Node root = n.getleftSkewed();
        diagonalTraversal(root);

    }

    static void diagonalTraversal(Node root){

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        ArrayList<Integer> diagonal = new ArrayList<>();

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur.left != null) queue.offer(cur.left);
            diagonal.add(cur.val);

            while(cur.right != null){
                cur = cur.right;
                diagonal.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
            }
        }

        System.out.println(diagonal);
    }
}
