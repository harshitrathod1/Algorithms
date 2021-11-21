package trees;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class inorderMorris {
    /*
     1. Traversal in O(1) space
     2. Left root right
     */
    static ArrayList<Integer> inorder = new ArrayList<>();
    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        morrisIn2(root);
        System.out.println(inorder);

    }

    static void morrisIn(Node root){

        Node cur = root;

        while(cur != null) {
            if (cur.left == null) {
                inorder.add(cur.val);
                cur = cur.right;
            } else {
                //rightmost element
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }

    static Node getRightNode(Node left,Node cur){

        while(left.right != null && left.right != cur){
            left = left.right;
        }

        return left;
    }

    static void morrisIn2(Node root){

        Node cur = root;

        while(cur != null){
            Node leftNode = cur.left;
            if(leftNode == null){
                inorder.add(cur.val);
                cur = cur.right;
            }else{
                Node rightMostNode = getRightNode(leftNode,cur);

                if(rightMostNode.right == null){
                    rightMostNode.right = cur;
                    cur = cur.left;
                }else{
                    //1. break the thread 2. record the val 3. Move to right
                    rightMostNode.right = null;
                    inorder.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }

}
