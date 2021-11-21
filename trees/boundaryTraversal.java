package trees;

import javax.sound.sampled.Line;
import java.util.*;

public class boundaryTraversal {

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        getBoundaryTraversal(root);
    }

    static class Pair{
        Node node;
        int x;
        int y;
        Pair(Node n,int _x,int _y){
            node = n;
            x = _x;
            y = _y;
        }
    }

    static ArrayList<Integer> leafNodesList = new ArrayList<>();

    static void getLeafNodes(Node root){
        if(root == null) return;

        if(root.left == null && root.right == null){
            leafNodesList.add(root.val);
            return;
        }
        if(root.left != null){
            getLeafNodes(root.left);
        }
        if(root.right != null){
            getLeafNodes(root.right);
        }
    }

    static void getBoundaryTraversal(Node root){
        ArrayList<Integer> boundary = new ArrayList<>();
        ArrayList<Integer> leftView = new ArrayList<>();
        ArrayList<Integer> rightView = new ArrayList<>();

        //TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> leafNodes = new TreeMap<>();

        if(root == null) return;
        Queue<Pair> queue = new ArrayDeque<>();

        queue.offer(new Pair(root,0,0));

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int node = 0;node < size;node++){
                Pair cur = queue.poll();
                if(cur.node.left == null && cur.node.right == null){

                }else if(node == 0){
                    leftView.add(cur.node.val);
                }else if(node == size - 1){
                    rightView.add(cur.node.val);
                }

                if(cur.node.left != null){
                    queue.offer(new Pair(cur.node.left,cur.x - 1,cur.y+1));
                }
                if(cur.node.right != null){
                    queue.offer(new Pair(cur.node.right, cur.x + 1,cur.y+1));
                }
            }
        }

        Collections.sort(rightView,Collections.reverseOrder());

        boundary.addAll(leftView);

        getLeafNodes(root);

        boundary.addAll(leafNodesList);

        boundary.addAll(rightView);

        System.out.println(boundary);
    }
}
