package trees;

import java.util.ArrayList;

public class preorderMorris {

    static ArrayList<Integer> preorder = new ArrayList<>();
    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        morrisPre(root);
        System.out.println(preorder);
    }

    static Node getRightMostNode(Node leftNode,Node cur){

        while(leftNode.right != null && leftNode.right != cur){
            leftNode = leftNode.right;
        }

        return leftNode;
    }

    //root left right
    static void morrisPre(Node root){
        Node cur = root;

        while(cur != null){
            Node leftNode = cur.left;
            if(leftNode == null){
                preorder.add(cur.val);
                cur = cur.right;
            }else{
                Node rightMostNode = getRightMostNode(leftNode,cur);

                if(rightMostNode.right == null){
                    rightMostNode.right = cur;
                    preorder.add(cur.val);
                    cur = cur.left;
                }else{
                    rightMostNode.right = null;
                    cur = cur.right;
                }
            }
        }
    }
}
