package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class topview {

    static Node getTree(){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        return root;
    }
    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        Node dummyRoot = getTree();
        topView(root);
    }

    //first node in every x coordinate

    static class Pair{
        Node node;
        int x;
        int y;
        Pair(Node n,int x,int y){
            node = n;
            this.x = x;
            this.y = y;
        }
    }

    static void topView(Node root){
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root,0,0));
        HashMap<Integer,Integer> map = new HashMap<>();

        ArrayList<Integer> topview = new ArrayList<>();

        while(!queue.isEmpty()){
            Pair top = queue.poll();

            //System.out.println(top.node.val + " "+ top.x+top.y);

            if(map.get(top.x) == null){
                map.put(top.x,top.node.val);
                topview.add(top.node.val);
            }

            if(top.node.left != null){
                queue.offer(new Pair(top.node.left,top.x - 1,top.y + 1));
            }

            if(top.node.right != null){
                queue.offer(new Pair(top.node.right, top.x+1,top.y+1));
            }
        }

        System.out.println(topview);
        System.out.println(map);
    }
}
