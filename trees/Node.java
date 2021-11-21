package trees;

import java.util.ArrayList;

public class Node {
    int val;
    Node left;
    Node right;
    ArrayList<Node> children;
    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    Node(){

    }

    Node(int val,ArrayList<Node> children){
        this.val = val;
        this.children = children;
    }

    public Node getDummyTree(){
        /*
                        10
                     /      \
                    20       30
                   /  \     /  \
                 40    50  60   70
                /  \  /  \      / \
              11  12 13  14    15 16
        * */
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);

        root.left.left.left = new Node(11);
        root.left.left.right = new Node(12);

        root.left.right.left = new Node(13);
        root.left.right.right = new Node(14);
        //root.left.right.right = new Node(100);

        root.right.left = new Node(60);
        root.right.right = new Node(70);

        root.right.right.left = new Node(15);
        root.right.right.right = new Node(16);

        return root;
    }

    public Node getDummyTree2(){

        int[] inorder = {7,4,8,2,5,1,11,9,10,6,3};
        int[] preorder = {1,2,4,7,8,5,3,6,9,11,10};

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Node left = root.left; Node right = root.right;
        //left part
        left.left = new Node(4);
        left.right = new Node(5);
        left.left.left = new Node(7);
        left.left.right = new Node(8);

        //right part
        right.right = new Node(6);
        right.right.left = new Node(9);
        right.right.left.left = new Node(11);
        right.right.left.right = new Node(10);

        return root;

    }

    //left Skewed
    public Node getleftSkewed(){

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.left.left = new Node(5);

        return root;
    }

}
