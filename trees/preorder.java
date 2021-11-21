package trees;

import java.util.Stack;

public class preorder {
    /*
        Preorder   root left right
        Inorder    left root right
        PostOrder  left right root
    * */

    public static void main(String[] args) {
        Node n = new Node();
        Node root = n.getDummyTree();
        preorderIter(root);
        System.out.println();
        preorderRec(root);
    }

    static void preorderRec(Node root){
        if(root == null) return;
        System.out.print(root.val+ " ");
        preorderRec(root.left);
        preorderRec(root.right);
    }
    static void preorderIter(Node root){
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.val+" ");
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }

    }



}
