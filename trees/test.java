package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        traversal(root);
    }

    static void traversal(Node node){
        if(node == null) return;

        System.out.print(node.val + " ");
        traversal(node.left);
        traversal(node.right);
    }


}
