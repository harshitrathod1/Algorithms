package trees;

import java.util.LinkedList;
import java.util.Queue;

public class levelorder {

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree2();

        bfs(root);
    }

    static void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.val+" ");

            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
}
